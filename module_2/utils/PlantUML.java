package utils;

import java.lang.reflect.*;

public class PlantUML {
    public PlantUML() {
    }

    private String getModifier(int modifiers) {
        if (Modifier.isPrivate(modifiers)) return "- ";
        if (Modifier.isProtected(modifiers)) return "# ";
        if (Modifier.isPublic(modifiers)) return "+ ";
        return "~ ";
    }

    private String formatType(Class<?> type) {
        return type.getSimpleName();
    }

    public void printUML(Class<?> cl) {
        System.out.println(cl.getSimpleName() + " {");

        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String visibility = this.getModifier(field.getModifiers());
            System.out.println("  " + visibility + formatType(field.getType()) + " " + field.getName());
        }

        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            String visibility = this.getModifier(constructor.getModifiers());
            StringBuilder params = new StringBuilder();
            for (Parameter param : constructor.getParameters()) {
                if (params.length() > 0) params.append(", ");
                params.append(formatType(param.getType())).append(" ").append(param.getName());
            }
            System.out.println("  " + visibility + cl.getSimpleName() + "(" + params + ")");
        }

        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            String visibility = this.getModifier(method.getModifiers());
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