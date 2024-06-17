package com.murari.test.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreams {

    // 1. Create a stream from a list and check the count of elements in the stream
    @Test
    public void createStreamFromCollection(){
        List<String> list= List.of("a", "b", "c");
        Stream<String> stream= list.stream();
        Assertions.assertEquals(3, stream.count());
    }

    // 2. Create a parallel stream from a list and check the count of elements in the stream
    @Test
    public void createParallelStreamFromCollection(){
        List<String> list= List.of("a", "b", "c");
        Stream<String> parallelStream= list.parallelStream();
        Assertions.assertEquals(3, parallelStream.count());
    }

    // 3. Create a stream from an array and check the count of elements in the stream
    @Test
    public void createStreamFromArray(){
        String[] list= {"a", "b", "c"};
        Stream<String> parallelStream= Stream.of(list);
        Assertions.assertEquals(3, parallelStream.count());
    }

    // 4. Create a stream using Stream.of() and check the count of elements in the stream
    @Test
    public void createUsingStreamOf(){
        Stream<String> parallelStream= Stream.of("a","b","c");
        Assertions.assertEquals(3, parallelStream.count());
    }

    // 5. Create an IntStream for a range of integers and check the count of elements in the stream
    @Test
    public void createFromStreamRange(){
        IntStream intStream= IntStream.range(1,5);  // 1,2,3,4
        Assertions.assertEquals(4, intStream.count());
    }

    // 6. Create a stream using Stream.iterate() and limit it to 3 elements, then check the count
    @Test
    public void createFromStreamIterate(){
        Stream<Integer> stream= Stream.iterate(0, n-> n+1).limit(3);
        Assertions.assertEquals(3, stream.count());
    }

    // 7. Create a stream from a BufferedReader and check the count of lines
    @Test
    public void createFromBufferedReader(){
        BufferedReader reader= new BufferedReader(new StringReader("line1\nline2\nline3"));
        Stream<String> stream= reader.lines();
        Assertions.assertEquals(3, stream.count());
    }

    // 8. Create a stream of file paths from a temporary directory and check the count of files
    @Test
    public void createFromFilePaths() throws IOException {
        Path tempDirectory= Files.createTempDirectory("testDir");
        Files.createTempFile(tempDirectory,"file1",".txt");
        Files.createTempFile(tempDirectory, "file2", ".txt");

        try(Stream<Path> pathStream= Files.list(tempDirectory)){
            Assertions.assertTrue(pathStream.count()>=2);
        }

    }

    // 9. Create a stream of random integers and check the count of elements
    @Test
    public void createFromRandomIntegers() {
        Random random= new Random();
        IntStream intStream= random.ints(5);
        Assertions.assertEquals(5, intStream.count());
    }

    // 10. Create a stream from a BitSet and check the count of set bits
    @Test
    public void createFromBitSet() {
        BitSet bitSet= new BitSet();
        bitSet.set(0);
        bitSet.set(2);
        bitSet.set(4);

        long countBit= bitSet.stream().count();
        Assertions.assertEquals(3,countBit);
    }

    // 11. Create a stream by splitting a string using a regex pattern and check the count of elements
    @Test
    public void testSplitAsStream() {
        Pattern pattern= Pattern.compile(",");
        Stream<String> stream= pattern.splitAsStream("a,b,c");
        Assertions.assertEquals(3,stream.count());
    }

    // 12. Mock a JarFile and create a stream of its entries, then check the count of entries
    @Test
    public void testJarFileStream() {
        JarFile jarFile= Mockito.mock(JarFile.class);
        JarEntry jarEntry1= new JarEntry("entry1");
        JarEntry jarEntry2= new JarEntry("entry2");

        Mockito.when(jarFile.stream()).thenReturn(Stream.of(jarEntry1, jarEntry2));
        Stream<JarEntry> stream= jarFile.stream();

        Assertions.assertEquals(2,stream.count());
    }

}
