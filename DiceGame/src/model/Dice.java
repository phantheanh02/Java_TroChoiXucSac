 /*  
  * Họ và tên: Phan Thế Anh
  * MSSV: 20204941
 */
package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Dice {
    private int id;
    private Map<Integer, Integer> faceBias = new HashMap<>();

    public Dice(int id) {
        this.id = id;
        this.createRandomBias();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Tạo mảng random
    private void createRandomBias() {
        for(int i = 1; i <= Constant.MAX_FACE; i++) {
            int bias = (i == this.id) ? Constant.MIN_PROBALITY : Constant.MAX_PROBALITY;
            faceBias.put(i, bias);
        }
    }

    // Random mặt
    public int roll() {
        int totalWeight = 0;
        for(int i = 1; i <= Constant.MAX_FACE; i++) {
            totalWeight += faceBias.get(i);
        }
        Random rand = new Random();
        // Random từ 0 đến totalWeight
        int number = rand.nextInt(totalWeight);
        for(int i = 1; i <= Constant.MAX_FACE; i++) {
            if(number < faceBias.get(i)) {
                return i;
            }
            number -= faceBias.get(i);
        }
        return 0;
    }

}
