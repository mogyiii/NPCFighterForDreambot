package Factory.Methods;

import Factory.Factory;
import org.dreambot.api.wrappers.items.Item;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Items {
    private Factory _factory;
    private Item[] StartedItems = new Item[]{};
    public Items(Factory factory) {
        _factory = factory;
    }
    public void setStartedItems(){
        for(int i = 0; i < _factory.getMain().getInventory().all().size() - 1; i++){
            StartedItems[i] = _factory.getMain().getInventory().all().get(i);
        }
    }

    public Item[] getStartedItems() {
        return StartedItems;
    }
    public List<Item> getStarterItemsList(){
        List<Item> ReturnItems = new List<Item>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Item> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Item item) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Item> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Item> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Item get(int index) {
                return null;
            }

            @Override
            public Item set(int index, Item element) {
                return null;
            }

            @Override
            public void add(int index, Item element) {

            }

            @Override
            public Item remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Item> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Item> listIterator(int index) {
                return null;
            }

            @Override
            public List<Item> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        for(int i = 0; i < StartedItems.length; i++){
            ReturnItems.add(StartedItems[i]);
        }
        return ReturnItems;
    }

}
