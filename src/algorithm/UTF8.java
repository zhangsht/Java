package algorithm;

public class UTF8 {
	public boolean validUtf8(int[] data) {
		if (data == null || data.length == 0) {
			return false;
		}
		
		boolean isValid = true;
		for (int i = 0; i < data.length; i++) {
			if (data[i] > 255) {
				return false;
			}
			
			int bytesNumber = 0;
			if ((data[i] & 128) == 0) {
				bytesNumber = 1;
			} else if ((data[i] & 224) == 192) {
				bytesNumber = 2;
			} else if ((data[i] & 240) == 224) {
				bytesNumber = 3;
			} else if ((data[i] & 248) == 240) {
				bytesNumber = 4;
			} else {
				return false;
			}
			
			for (int j = 1; j < bytesNumber; j++) {
				if ((i + j >= data.length) || (data[i + j] & 192) != 128 || data[i + j] > 255) {
					return false;
				}
			}
			i += (bytesNumber - 1);
		}
		return isValid;
	}
	public static void main(String[] args) {
		UTF8 utf8 = new UTF8();
		int[] arr = {235, 140, 4};
		System.out.println(utf8.validUtf8(arr));
	}
}
