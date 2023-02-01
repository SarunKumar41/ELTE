
/*
Draw the memory map of the following Java program! (Present the contents of the execution stack and the heap!)
*/
class Foo {
    private int x;

    public Foo(int x) {
        this.x = x;
    }
}

public class Main {
    public static void main(String[] args) {
        Foo obj = new Foo(0);  //(1)
        obj = new Foo(10); //(2)
        Foo obj2 = obj; //(3)
        int i = 1; //(4)
        obj2 = new Foo(20); //(5)
    }
}


/* Map
//(1) Stack:                obj=Ref1   Heap: Ref1=Foo(0)
//(2) Stack:                obj=Ref2   Heap: Ref2=Foo(10)
//(3) Stack:      obj=Ref2  obj2=Ref2  Heap: Ref2=Foo(10)
//(4) Stack: i=1  obj=Ref2  obj2=Ref2  Heap: Ref2=Foo(10)
//(5) Stack: i=1  obj=Ref2  obj2=Ref3  Heap: Ref2=Foo(10) Ref3=Foo(20)
*/