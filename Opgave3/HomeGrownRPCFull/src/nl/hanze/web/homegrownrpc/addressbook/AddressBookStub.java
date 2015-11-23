package nl.hanze.web.homegrownrpc.addressbook;

import java.util.List;

public class AddressBookStub extends nl.hanze.web.homegrownrpc.generic.Stub implements nl.hanze.web.homegrownrpc.addressbook.AddressBook {

    public void addStudent(Student student) throws Exception {
        invokeSkel("addStudent", new java.lang.Class[] {nl.hanze.web.homegrownrpc.addressbook.Student.class}, new java.lang.Object[] {student});
    }

    public boolean removeStudent(int stdNummer) throws Exception {
        java.lang.Object o=invokeSkel("removeStudent", new java.lang.Class[] {int.class}, new java.lang.Object[] {stdNummer});
        return ((java.lang.Boolean) o).booleanValue();
    }

    public List<Student> getAllStudentsAsList() throws Exception {
        java.lang.Object o=invokeSkel("getAllStudentsAsList", null, null);
        return (java.util.List<Student>) o;
    }

    public Student[] getAllStudentsAsArray() throws Exception {
        java.lang.Object o=invokeSkel("getAllStudentsAsArray", null, null);
        return (nl.hanze.web.homegrownrpc.addressbook.Student[]) o;
    }

    public int countStudents() throws Exception {
        java.lang.Object o=invokeSkel("countStudents", null, null);
        return ((java.lang.Integer) o).intValue();
    }

}
