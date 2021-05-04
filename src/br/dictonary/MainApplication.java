package br.dictonary;

import br.dictonary.search.BinaryTree;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.stream.Stream;

public class MainApplication {

    public static void main(String[] args) {
        String pathname = "/Users/luisfernando_dmo/Projects/ufc/distributed_systems/exercises/dictionary/data/input.txt";
        File file = new File(pathname);
        BinaryTree binaryTree = BinaryTree.of();

        try(Stream<String> lines = Files.lines(file.toPath())){
            lines.forEach(binaryTree::addNode);
        }catch (IOException io){
            System.out.println("It is not possible to read or file");
        }

        binaryTree.order();
        System.out.println("Total de palavras diferentes no dicionario: " + binaryTree.getAmount());
    }
}
