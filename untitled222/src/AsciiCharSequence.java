import java.util.stream.IntStream;

public class AsciiCharSequence implements java.lang.CharSequence{
    private byte[] asciiCharSequence;
    public AsciiCharSequence(byte[] ByteSequence){
        asciiCharSequence = ByteSequence;
    }

    public int length(){
        return asciiCharSequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char)asciiCharSequence[index];
    }

    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        int size = (end - start);
        int j = 0;
        byte[] bss = new byte[size];
        for (int i = start; i < end; i++) {
            bss[j] = asciiCharSequence[i];
            j++;
        }
        AsciiCharSequence cs = new AsciiCharSequence(bss);
        return cs;
    }
}
