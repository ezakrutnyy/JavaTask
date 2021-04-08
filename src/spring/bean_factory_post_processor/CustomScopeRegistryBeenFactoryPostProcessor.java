package spring.bean_factory_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import spring.skope.PeriodicalScopeConfigurer;

@Component
public class CustomScopeRegistryBeenFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beenFactory) throws BeansException {
        beenFactory.registerScope("periodical", new PeriodicalScopeConfigurer());
    }
}
