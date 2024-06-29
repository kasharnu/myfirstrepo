package modelpro;

public class palindrome {

	
public static boolean checkpali(int num) {
	int temp=num;
	int ans=0;
	while(num>0) {
		ans=ans*10+num%10;
		num/=10;
	}
	if(temp==ans) {
		return true;
	}
	return false;
}
}
