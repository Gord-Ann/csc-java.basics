package anna.third;

import java.lang.CharSequence;

public class AsciiCharSequence implements CharSequence {
    private final byte[] array;

    public AsciiCharSequence(byte[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return new String(array);
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return (char) array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] ex = new byte[end - start];
        for (int a = 0; a < end - start; a++)
            ex[a] = (byte) this.charAt(start + a);
        return new AsciiCharSequence(ex);
    }

}
