package serialization.serializable;

import java.io.Serializable;

public class Fabric implements Serializable {

    String material;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Fabric{" +
                "material='" + material + '\'' +
                '}';
    }
}
