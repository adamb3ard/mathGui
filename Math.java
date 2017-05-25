import java.util.Arrays;
/**
 * 
 * @author Adam Banks Beard
 * 
 * A class that implements mathematics to perform the desired operation
 *
 */
public class Math implements Mathematics{
	
	/**
	 * @override
	 * @param add
	 * @return sum
	 * A method to add the numbers in the array add
	 */
	public float addition(float... add) {
		float sum = 0;
		
		for(int i = 0; i < add.length; i++){
			sum += add[i];
		}
		
		return sum;
	}
	
	/**
	 * @override
	 * @param sub
	 * @return dif
	 * A method that subtracts the numbers from the array sub 
	 */
	public float subtraction(float... sub) {
		float dif = sub[0];
		
		for(int i = 1; i < sub.length; i++){
			dif -= sub[i];
		}
		
		return dif;
	}

	/**
	 * @override
	 * @param mult
	 * @return prod
	 * A method that multiplies the numbers in the array mult
	 */
	public float multiplication(float... mult) {
		float prod = 1;
		
		for (int i = 0; i < mult.length; i++){
			prod *= mult[i];
		}
		
		return prod;
	}

	/**
	 * @override
	 * @param div
	 * @return quot
	 * A method that divides the numbers in the array div
	 */
	public float division(float... div) {
		float quot = div[0];
		
		for(int i = 1; i < div.length; i++){
			quot /= div[i];
		}
		
		return quot;
	}

	/**
	 * @override
	 * @param max
	 * @return up
	 * A method that finds the highest value in the array max
	 */
	public float findMax(float... max) {
		float up = max[0];
		
		for(int i = 1; i < max.length; i++){
			if(max[i] > up){
				up = max[i];
			}
			
		}
		
		return up;
	}

	/**
	 * @Override
	 * @param min
	 * @return bot
	 * A method that finds the lowest value in the array min
	 */
	public float findMin(float... min) {
		float bot = min[0];
		for(int i = 1; i < min.length; i++){
			if(min[i] < bot){
				bot = min[i];
			}
		}
		
		return bot;
	}

	/**
	 * @Override
	 * @param avg
	 * @return average
	 * A method that finds the average of the numbers in the array avg
	 */
	public float getAverage(float... avg) {
		float average = this.addition(avg) / avg.length;
		
		return average;
	}
	
	/**
	 * @Override
	 * @param med
	 * @return mid
	 * A method that finds the median of the numbers in the array med
	 */
	public float getMedian(float... med){
		float mid = 0;
		
		Arrays.sort(med);

		if(med.length % 2 == 0){
			int up = med.length / 2;
			int low = up - 1;
			float added = med[up] + med[low];
			float average = added / 2;
			mid = average; 
		}
		else if(med.length %2 != 0){
			mid = med[med.length / 2];
		}
		return mid;
	}

}
