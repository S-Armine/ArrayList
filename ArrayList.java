import java.util.Arrays;
public class ArrayList<E> implements List<E> {

    private int currentCapacity = 10;
    private int currentSize = 0;
    private E[] arrayList;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        arrayList = (E[]) new Object[currentCapacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayList(E ... args) {
        if(args.length > currentCapacity) {
            currentCapacity += args.length;
        }
        arrayList = (E[]) new Object[currentCapacity];
        System.arraycopy(args, 0, arrayList, 0, args.length);
        currentSize = args.length;
    }

    @Override
    public int size() {
        return currentSize;
    }

    public int capacity() {
        return currentCapacity;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @SuppressWarnings("unchecked")
    private void extendedArrayCreation() {
        currentCapacity += 10;
        E[] temp = arrayList;
        arrayList = (E[]) new Object[currentCapacity];
        System.arraycopy(temp, 0, arrayList, 0, currentSize);
    }

    @SuppressWarnings("unchecked")
    private void extendedArrayCreation(int size) {
        currentCapacity += (size + 10);
        E[] temp = arrayList;
        arrayList = (E[]) new Object[currentCapacity];
        System.arraycopy(temp, 0, arrayList, 0, currentSize);
    }

    @Override
    public boolean add(E element) {
        if (currentSize >=  currentCapacity) extendedArrayCreation();
        arrayList[currentSize++] = element;
        return true;
    }

    @Override
    public void add(int index, E element) {
        try {
            isInvalidIndexForAdd(index);
            if (currentSize == currentCapacity) extendedArrayCreation();
            for (int i = currentSize; i > index; i--) {
                arrayList[i] = arrayList[i - 1];
            }
            arrayList[index] = element;
            currentSize++;

        } catch (InvalidIndexException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public E get(int index) {
        try {
            isInvalidIndex(index);
            return arrayList[index];
        } catch (InvalidIndexException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public E set(int index, E element) {
        try {
            isInvalidIndex(index);
            E temp = arrayList[index];
            arrayList[index] = element;
            return temp;
        } catch (InvalidIndexException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean remove(E element) {
        if (contains(element)) {
            remove(indexOf(element));
            return true;
        }
        return false;
    }

    @Override
    public E remove(int index) {
        try {
            isInvalidIndex(index);
            E temp = arrayList[index];
            for (int i = index; i < currentSize; i++) {
                arrayList[i] = arrayList[i + 1];
            }
            arrayList[--currentSize] = null;
            return temp;
        } catch (InvalidIndexException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < currentSize; i++) {
            if (arrayList[i].equals(element)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        for (int i = currentSize - 1; i >= 0; i--) {
            if (arrayList[i].equals(element)) return i;
        }
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        arrayList = (E[]) new Object[currentCapacity];
        currentSize = 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arrayList, currentSize);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] array) {
        if (this.isEmpty()) return array;
        try{
            array[0] = (T) arrayList[0];
        } catch (ArrayStoreException e) {
            System.out.println(e.getClass());
            return null;
        }
        if (array.length < currentSize)  array = (T[]) new Object[currentSize];
        for (int i = 0; i < currentSize; i++) {
            array[i] = (T) arrayList[i];
        }
        return array;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        isInvalidIndex(fromIndex);
        isInvalidIndex(toIndex);
        if(fromIndex >= toIndex) throw new InvalidIndexException("Not valid indexes were passed as parameters.");
        List<E> list = new ArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) list.add(arrayList[i]);
        return list;
    }

    @Override
    public boolean removeAll(List<? extends E> otherList) {
        boolean isModified = false;
        for (int i = 0; i < otherList.size(); i++) {
            if (this.contains((E) otherList.get(i))) {
                this.remove((E) otherList.get(i));
                isModified = true;
            }
        }
        return isModified;
    }

    @Override
    public boolean retainAll(List<? extends E> otherList) {
        boolean isModified = false;
        ArrayList<E> otherArray = new ArrayList<>();
        otherArray.addAll(otherList);
        for (int i = 0; i < currentSize; i++) {
            if(!otherArray.contains((arrayList[i]))) {
                this.remove(arrayList[i]);
                i--;
                isModified = true;
            }
        }
        return isModified;
    }

    @Override
    public boolean containsAll(List<? extends E> otherList) {
        for (int i = 0; i < otherList.size(); i++) {
            if (! this.contains((E) otherList.get(i))) {
               return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(List<? extends E> otherList) {
        if (currentSize + otherList.size() >= currentCapacity) {
            extendedArrayCreation(otherList.size());
        }
        for (int i = 0; i < otherList.size(); i++) {
            this.add(otherList.get(i));
        }
        return true;
    }

    @Override
    public boolean addAll(int index, List<? extends E> otherList) {
        try{
            isInvalidIndexForAdd(index);
            if(index == currentSize) {
                return this.addAll(otherList);
            }
            if(currentSize + otherList.size() > currentCapacity) {
                extendedArrayCreation(otherList.size());
            }
            for (int i = 0; i < otherList.size(); i++) {
                this.add(index + i, otherList.get(i));
            }
            return true;
        } catch (InvalidIndexException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void isInvalidIndex(int index) {
        if (index < 0) {
            throw new InvalidIndexException("Negative index is not allowed.");
        }
        else if (index >= currentSize) {
            throw new InvalidIndexException("Index is out of bounds.");
        }
    }

    private void isInvalidIndexForAdd(int index) {
        if (index < 0) {
            throw new InvalidIndexException("Negative index is not allowed.");
        }
        else if (index > currentSize) {
            throw new InvalidIndexException("Index is out of bounds.");
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        StringBuilder arrayString = new StringBuilder();
        arrayString.append("[");
        for (int i = 0; i < currentSize - 1; i++) {
            arrayString.append(arrayList[i] + ", ");
        }
        if (currentSize == 0) arrayString.append("]");
        else arrayString.append(arrayList[currentSize - 1] + "]");
        return arrayString.toString();
    }
}
