package sample;

public class Control {
    private ControlType type;
    private String description;

    public Control(ControlType type, String description) {
        this.type = type;
        this.description = description;
    }

    public ControlType getType() {
        return type;
    }

    public void setType(ControlType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Control{" +
                "type=" + type +
                ", description='" + description + '\'' +
                '}';
    }
}