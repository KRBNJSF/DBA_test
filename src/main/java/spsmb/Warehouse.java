package spsmb;

import javafx.beans.property.*;

import java.util.List;

public class Warehouse {

    private final ReadOnlyIntegerWrapper id =
            new ReadOnlyIntegerWrapper(this, "id", 0); //idSequence.incrementAndGet());
    private final StringProperty name =
            new SimpleStringProperty(this, "name", null);
    private final IntegerProperty capacity =
            new SimpleIntegerProperty(this, "capacity", 0);

    // Keeps track of last generated person id
    //private static AtomicInteger idSequence = new AtomicInteger(0);

    public Warehouse() {
        this(0, null, 0);
    }

    public Warehouse(int id, String name, int capacity) {
        this.id.set(id);
        this.name.set(name);
        this.capacity.set(capacity);
    }

    /* Id Property */
    public final int getId() {
        return id.get();
    }

    public final ReadOnlyIntegerProperty idProperty() {
        return id.getReadOnlyProperty();
    }

    /* Name Property */
    public final String getName() {
        return name.get();
    }
    public final void setName(String name) {
        nameProperty().set(this.getName());
    }
    public final StringProperty nameProperty() {
        return name;
    }

    public final int getCapacity() {
        return capacity.get();
    }
    public final void setCapacity(int capacity) {
        capacityProperty().set(this.getCapacity());
    }
    public final IntegerProperty capacityProperty() {
        return capacity;
    }



    /* Domain specific business rules */
    public boolean isValidWarehouse(List<String> errorList) {
        return isValidWarehouse(this, errorList);
    }

    /* Domain specific business rules */
    public boolean isValidWarehouse(Warehouse w, List<String> errorList) {
        boolean isValid = true;
        String fn = w.name.get();
        if (fn == null || fn.trim().length() == 0) {
            errorList.add("First name must contain minimum one character.");
            isValid = false;
        }
        return isValid;
    }

    /* Domain specific business rules */
    public boolean save(List<String> errorList) {
        boolean isSaved = false;
        if (isValidWarehouse(errorList)) {
            System.out.println("Saved " + this.toString());
            isSaved = true;
        }
        return isSaved;
    }

    @Override
    public String toString() {
        return "[id=" + id.get() +
                ", capacity=" + capacity.get() +
                ", name=" + name.get() + "]";
    }
}
