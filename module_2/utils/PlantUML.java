package utils;

import java.lang.reflect.*;

public class PlantUML {
    public PlantUML() {
    }

    private String getModifier(int modifiers) {
        if (Modifier.isPrivate(modifiers)) return "- "; // Private
        if (Modifier.isProtected(modifiers)) return "# "; // Protect
        if (Modifier.isPublic(modifiers)) return "+ "; // Public
        return "~ "; // Default
    }

    private String formatType(Class<?> type) {
        return type.getSimpleName();
    }

    public void printUML(Class<?> cl) {
        System.out.println(cl.getSimpleName() + " {");

        // Lấy và in ra các thuộc tính của class
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String visibility = this.getModifier(field.getModifiers());
            System.out.println("  " + visibility + formatType(field.getType()) + " " + field.getName());
        }

        // In ra các hàm khởi tạo trong class
        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            String visibility = this.getModifier(constructor.getModifiers());

            // Lấy ra các param hiện có trong hàm khởi tạo và thêm vào mảng params[]
            StringBuilder params = new StringBuilder();
            for (Parameter param : constructor.getParameters()) {
                if (params.length() > 0) params.append(", ");
                params.append(formatType(param.getType())).append(" ").append(param.getName());
            }
            System.out.println("  " + visibility + cl.getSimpleName() + "(" + params + ")");
        }

        // Lấy và in ra các phương thức hiện có trong class 
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            String visibility = this.getModifier(method.getModifiers());

            // Lấy ra các param hiện có trong hàm và thêm vào mảng params[]
            StringBuilder params = new StringBuilder();
            for (Parameter param : method.getParameters()) {
                if (params.length() > 0) params.append(", ");
                params.append(formatType(param.getType())).append(" ").append(param.getName());
            }
            System.out.println("  " + visibility + formatType(method.getReturnType()) + " " + method.getName() + "(" + params + ")");
        }

        System.out.println("}");
    }
}
