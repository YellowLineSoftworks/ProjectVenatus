/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


public class Test {
    public static void main(String[] args){
        Tile t = Tile.deSerialize(2, 2);
        System.out.println(t.location);
    }
}
