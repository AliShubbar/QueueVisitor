package matrix5;

import javafx.beans.property.SimpleStringProperty;

// تعريف المتغيرات التي سوف ينم استيرادها ووضعها ضمن الحقول المعرفة
public class Person {
    private SimpleStringProperty Id, Name;

  // من خلال الجنريتر يتم استخلاص خذخ الكونستركتر  
 public Person(String Id, String Name) {
        this.Id = new SimpleStringProperty(Id);
        this.Name =new SimpleStringProperty (Name);
    }
    
// يجب تحويلها ال String بدون السترنغ سوف يكون خطاء في العرض على التيبل
    public String getId() {
        return Id.get();
    }

    public void setId(String Id) {
        this.Id = new SimpleStringProperty(Id);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String Name) {
        this.Name = new SimpleStringProperty(Name);
    }

    @Override
     public String toString()
    {
        return String.format("%s %s", Id, Name);
    }
}