package GeeksForGeeks.Arrays;

import java.util.List;

/**
 * Created by prashantgolash on 01/01/16.
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(List<Boolean> flowerbed, int numberToPlace) {
        this.hashCode();
        if(flowerbed == null || flowerbed.isEmpty()){
            throw new IllegalArgumentException("bed is empty");
        }

        if(numberToPlace==0)
            return true;

        if(flowerbed.size()==1){
            return !flowerbed.get(0) && numberToPlace<=1;
        }

        int counter = 0;

        for(int i=0; i< flowerbed.size(); i++){
            if(!flowerbed.get(i)){
                if((i==0 && !flowerbed.get(i+1))
                        || (i==flowerbed.size()-1 && !flowerbed.get(i-1))
                        || (!flowerbed.get(i+1) && !flowerbed.get(i-1)) ){
                    //place the flower
                    flowerbed.set(i, true);
                    counter++;
                    if(counter==numberToPlace)
                        return true;
                }
            }
        }
        return false;
    }

}
