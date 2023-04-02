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
public interface Lock {
    void requestCS(int tid);
    void releaseCS(int tid);
}
