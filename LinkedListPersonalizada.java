package sample;

import java.util.Objects;

public class LinkedListPersonalizada<T> extends ListValidation implements List<T> {

    private NoList<T> first;
    private NoList<T> last;
    private Integer counter;

    LinkedListPersonalizada() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    @Override
    public void add(T item) throws Exception {
        NoList<T> newNo = new NoList<T>(item, null);

        if (counter.equals(0)) {
            first = new NoList<T>(null, newNo);
        } else {
            boolean isLooping = true;
            NoList<T> noList = this.first.getNext();

            do {
                if (Objects.isNull(noList.getNext())) {
                    isLooping = false;

                    noList.setNext(newNo);
                }

                noList = noList.getNext();
            } while (isLooping);
        }
    }

    @Override
    public void add(int index, T item) throws Exception {
        this.indexBiggerOrMinorTheList(counter, index);

        if (this.counter.equals(0)) {
            NoList<T> newNo = new NoList(item, null);
            this.first = new NoList<T>(null, newNo);
            this.last = new NoList<T>(item, null);
        } else {
            NoList<T> noListLooping = this.first.getNext();
            NoList<T> noListLoopingAnterior = this.first;
            boolean isLooping = true;
            int indexLooping = 0;

            do {
                if (indexLooping == index) {
                    isLooping = false;

                    NoList<T> newNo = new NoList<T>(item, noListLooping);
                    noListLoopingAnterior.setNext(newNo);
                } else {
                    noListLoopingAnterior = noListLooping;
                    noListLooping = noListLooping.getNext();
                    indexLooping++;
                }
            } while (isLooping);
        }
    }

    @Override
    public T remove(int index) throws Exception {
        this.indexBiggerOrMinorTheList(counter, index);

        T oldValue = null;

        NoList<T> noListLooping = this.first.getNext();
        NoList<T> noListLoopingAnterior = this.first;
        boolean isLooping = true;
        int indexLooping = 0;

        do {
            if (indexLooping == index) {
                oldValue = noListLooping.getInfo();

                NoList<T> noReplace = noListLooping.getNext();
                if (Objects.isNull(noReplace)) {
                    noListLoopingAnterior.setNext(null);
                    this.last = noListLoopingAnterior;
                } else {
                    noListLoopingAnterior.setNext(noReplace);
                }

                isLooping = false;
            } else {
                noListLoopingAnterior = noListLooping;
                noListLooping = noListLooping.getNext();
                indexLooping++;
            }
        } while (isLooping);

        counter--;
        return oldValue;
    }

    @Override
    public boolean removeFirst(T item) throws Exception {
        boolean retorno = false;
        NoList<T> noListLooping = this.first.getNext();
        boolean isLooping = true;
        int indexLooping = 0;

        do {
            if (Objects.isNull(noListLooping)) {
                isLooping = false;
            } else {
                if (noListLooping.getInfo().equals(item)) {
                    this.remove(indexLooping);
                    isLooping = false;
                    retorno = true;
                } else {
                    noListLooping = noListLooping.getNext();
                    indexLooping++;
                }
            }
        } while (isLooping);

        return retorno;
    }

    @Override
    public T get(int index) throws Exception {
        this.indexBiggerOrMinorTheList(counter, index);
        T item = null;

        NoList<T> noListLooping = this.first.getNext();
        boolean isLooping = true;
        int indexLooping = 0;

        do {
            if (index == indexLooping) {
                item = noListLooping.getInfo();
                isLooping = false;
            } else {
                noListLooping = noListLooping.getNext();
                indexLooping++;
            }
        } while (isLooping);

        return item;
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    @Override
    public T set(int index, T item) throws Exception {
        this.indexBiggerOrMinorTheList(counter, index);

        T retorno = null;
        NoList<T> noListLooping = this.first.getNext();
        NoList<T> noListLoopingAnterior = this.first;
        boolean isLooping = true;
        int indexLooping = 0;

        do {
            if (index == indexLooping) {
                retorno = noListLooping.getInfo();
                NoList<T> newNo = new NoList<T>(item, noListLooping.getNext());
                noListLoopingAnterior.setNext(newNo);
                isLooping = false;
            } else {
                noListLoopingAnterior = noListLooping;
                noListLooping = noListLooping.getNext();
                indexLooping++;
            }
        } while (isLooping);

        return retorno;
    }

    @Override
    public int size() {
        return this.counter;
    }

    @Override
    public boolean isEmpty() {
        return this.counter.equals(0);
    }

    @Override
    public boolean contains(T item) {
        boolean retorno = false;
        if (Objects.nonNull(this.first)) {
            NoList<T> noListLooping = this.first.getNext();
            boolean isLooping = true;
            int indexLooping = 0;

            do {
                if (Objects.isNull(noListLooping)) {
                    isLooping = false;
                } else {
                    if (noListLooping.getInfo().equals(item)) {
                        isLooping = false;
                        retorno = true;
                    } else {
                        noListLooping = noListLooping.getNext();
                        indexLooping++;
                    }
                }
            } while (isLooping);
        }

        return retorno;
    }

    @Override
    public int indexOf(T item) {
        int indice = -1;

        if (Objects.nonNull(this.first)) {
            NoList<T> noListLooping = this.first.getNext();
            boolean isLooping = true;
            int indexLooping = 0;

            do {
                if (Objects.isNull(noListLooping)) {
                    isLooping = false;
                } else {
                    if (noListLooping.getInfo().equals(item)) {
                        indice = indexLooping;
                        isLooping = false;
                    } else {
                        noListLooping = noListLooping.getNext();
                        indexLooping++;
                    }
                }
            } while (isLooping);
        }

        return indice;
    }

    @Override
    public int lastIndexOf(T item) {
        int indice = -1;

        if (Objects.nonNull(this.first)) {
            NoList<T> noListLooping = this.first.getNext();
            boolean isLooping = true;
            int indexLooping = 0;

            do {
                if (Objects.isNull(noListLooping)) {
                    isLooping = false;
                } else {
                    if (noListLooping.getInfo().equals(item)) {
                        indice = indexLooping;
                    } else {
                        noListLooping = noListLooping.getNext();
                        indexLooping++;
                    }
                }
            } while (isLooping);
        }

        return indice;
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[counter];

        if (Objects.nonNull(this.first)) {
            NoList<T> noListLooping = this.first.getNext();
            boolean isLooping = true;
            int indexLoaping = 0;

            do {
                if (Objects.isNull(noListLooping)) {
                    isLooping = false;
                } else {
                    array[indexLoaping] = noListLooping.getInfo();
                    noListLooping = noListLooping.getNext();
                    indexLoaping++;
                }
            } while (isLooping);
        }

        return array;
    }
}
