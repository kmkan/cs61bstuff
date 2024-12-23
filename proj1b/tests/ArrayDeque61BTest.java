import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

     @Test
     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
     void noNonTrivialFields() {
         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                 .toList();

         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
     }


    @Test
    public void testGetMultipleIndexes() {
         Deque61B<Integer> ad1 = new ArrayDeque61B<>();

         ad1.addFirst(3);
         ad1.addFirst(2);
         ad1.addFirst(1) ;
        ad1.addFirst(0);
        ad1.addFirst(-1);

        ad1.addLast(4);
        ad1.addLast(5);
        ad1.addLast(6);
        ad1.addLast(7);
        ad1.addLast(8);


        assertThat(ad1.get(7)).isEqualTo(-1);
        assertThat(ad1.get(16)).isEqualTo(8);
    }

    @Test
    public void testSize() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();
        assertThat(ad1.size()).isEqualTo(0);

        ad1.addFirst(2);
        assertThat(ad1.size()).isEqualTo(1);

        ad1.addLast(3);
        assertThat(ad1.size()).isEqualTo(2);
    }

    @Test
    public void testIsEmpty() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        assertThat(ad1.isEmpty()).isTrue();

        ad1.addFirst(3);
        assertThat(ad1.isEmpty()).isFalse();
    }

    @Test
    public void testToList() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        assertThat(ad1.toList()).containsExactly().inOrder();

        ad1.addFirst(3);
        ad1.addLast(5);
        ad1.addLast(5);
        ad1.addFirst(4);

        assertThat(ad1.toList()).containsExactly(4, 3, 5, 5).inOrder();
    }

    @Test
    public void testRemoveFirst() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        assertThat(ad1.removeFirst()).isEqualTo(null);
        assertThat(ad1.toList()).containsExactly().inOrder();

        ad1.addLast(5);
        ad1.addFirst(1);

        assertThat(ad1.removeFirst()).isEqualTo(1);
        assertThat(ad1.removeFirst()).isEqualTo(5);
        assertThat(ad1.removeFirst()).isEqualTo(null);
    }

    @Test
    public void testRemoveLast() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        assertThat(ad1.removeFirst()).isEqualTo(null);
        assertThat(ad1.toList()).containsExactly().inOrder();

        ad1.addLast(5);
        ad1.addFirst(1);

        assertThat(ad1.removeLast()).isEqualTo(5);
        assertThat(ad1.removeLast()).isEqualTo(1);
        assertThat(ad1.removeLast()).isEqualTo(null);
    }

}
