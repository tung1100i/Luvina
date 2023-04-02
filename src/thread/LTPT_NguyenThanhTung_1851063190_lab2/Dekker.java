/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.LTPT_NguyenThanhTung_1851063190_lab2;

/**
 *
 * @author hp
 */
public class Dekker implements Lock {
    int turn = 1;
    boolean[] wantCS = {false, false};

    @Override
     @SuppressWarnings("empty-statement")
    public void requestCS(int i) { // i = 0 hoac 1
        int j = 1 - i;
     
        wantCS[i] = true;
        while (wantCS[j]) {
            if (turn == j) {               
                wantCS[i] = false;
                while (turn == j);
                wantCS[i] = true;      	
            }
        }
    
    }

    @Override
    public void releaseCS(int i) { // i = 0 hoac 1      
            turn = 1 - i;
            wantCS[i] = false;
            
        }
}
