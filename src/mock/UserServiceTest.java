package mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.invocation.InvocationOnMock;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private static final String PASSWORD = "password";

    private final User ENABLED_USER = new User(1L, "hash", true);

    private final User DISABLED_USER = new User(2L, "disabled user password hash", false);

    private UserRepository repository;

    private PasswordEnconder passwordEnconder;

    private UserService userService;

    @Before
    public void init() {
        repository = createUserRepository();
        passwordEnconder = createPasswordEnconder();
        userService = new UserService(repository, passwordEnconder);
    }


    private UserRepository createUserRepository() {
        UserRepository mock = mock(UserRepository.class);
        when(mock.findById(ENABLED_USER.getId())).thenReturn(ENABLED_USER);
        when(mock.findById(DISABLED_USER.getId())).thenReturn(DISABLED_USER);
        return mock;
    }

    private PasswordEnconder createPasswordEnconder() {
        PasswordEnconder mock = mock(PasswordEnconder.class);
        when(mock.encode(anyString())).thenReturn("any password hash");
        when(mock.encode(PASSWORD)).thenReturn(ENABLED_USER.getPasswordHash());
        when(mock.encode("rrn")).thenAnswer(invocation -> {
            throw new IllegalArgumentException();});
        when(mock.encode("inn")).thenAnswer(invocation -> {
            Object[] lists = invocation.getArguments();
            return lists[0]+"_kpp";
        });
        return mock;
    }


    @Test
    public void shouldBeValid() {
        boolean userIsValid = userService.isValidUser(ENABLED_USER.getId(), PASSWORD);
        assertTrue(userIsValid);

        verify(repository).findById(ENABLED_USER.getId());

        verify(passwordEnconder).encode(PASSWORD);
    }

    @Test
    public void shouldBeInvalid() {
        boolean userIsValid = userService.isValidUser(100L, "invalid");
        assertFalse(userIsValid);

        InOrder inOrder = inOrder(repository, passwordEnconder);
        inOrder.verify(repository).findById(100L);
        inOrder.verify(passwordEnconder, never()).encode(anyString());
    }

    @Test
    public void shouldBeInvalid2() {
        boolean userIsValid = userService.isValidUser(ENABLED_USER.getId(), "invalid");
        assertFalse(userIsValid);

        userIsValid = userService.isValidUser(ENABLED_USER.getId(), "po");
        assertFalse(userIsValid);

        // захватывает последнее сообщение
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(passwordEnconder, atLeastOnce()).encode(captor.capture());
        assertEquals("po", captor.getValue());
    }

    @Test
    public void shouldBeInvalid3() {
        boolean userIsValid = userService.isValidUser(ENABLED_USER.getId(), "invalid");
        assertFalse(userIsValid);

        userIsValid = userService.isValidUser(ENABLED_USER.getId(), "po");
        assertFalse(userIsValid);

        // захватывает последнее сообщение
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(passwordEnconder, atLeastOnce()).encode(captor.capture());
        assertEquals("po", captor.getValue());
    }

    @Test
    public void shouldBeInvalid4() {
        boolean userIsValid = userService.isValidUser(DISABLED_USER.getId(), PASSWORD);
        assertFalse(userIsValid);

        verify(repository).findById(DISABLED_USER.getId());

        verifyZeroInteractions(passwordEnconder);
    }

    @Test
    public void thenAnswerTest() {
        String res = passwordEnconder.encode("inn");
        assertEquals(res, "inn_kpp");
    }

    @Test
    public void doAnswerTest() {
        Date mock = mock(Date.class);
        doAnswer(InvocationOnMock::callRealMethod).when(mock).setTime(42);
        doAnswer(InvocationOnMock::callRealMethod).when(mock).getTime();
        mock.setTime(42);
        assertEquals(42, mock.getTime());
    }

    @Test
    public void callRealMethod() {
        Date mock = mock(Date.class);
        when(mock.getTime()).thenCallRealMethod();
        doCallRealMethod().when(mock).setTime(45);

        mock.setTime(45);
        assertEquals(45, mock.getTime());
    }

    @Test
    public void thenThrowMethod() {
        Date mock = mock(Date.class);
        when(mock.getTime()).thenThrow(new IllegalArgumentException());
        doThrow(new IllegalArgumentException()).when(mock).setTime(15);
        mock.setTime(15);
    }


}