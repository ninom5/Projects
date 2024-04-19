#include<iostream>
#include<time.h>
#include<stdlib.h>

using namespace std;

int wuhu(int res);
int k(int res);

int main()
{
	int res = 0;
	int comb = 0;
	cin >> res;
	srand(time(NULL));
	if (res <= 60)
	{
		res = wuhu(res);
	}
	else if (res > 60 && res < 120)
	{
		while (res != 0)
		{
			int temp = 3*20;
			res -= temp;
			cout << "triple 20" << endl;
			res = wuhu(res);
		}
	}
	else
	{
		k(res);
	}

	return 0;
}
int wuhu(int res)
{
	srand(time(NULL));

	int comb = 0;

	while (res != 0)
	{
		if (res == 25)
		{
			comb = res;
			res -= comb;
			cout << comb << endl;
		}
		else if (res == 50)
		{
			comb = res / 2;
			res -= comb * 2;
			cout << "double" << comb << endl;
		}
		else if (res % 3 == 0)
		{
			comb = res / 3;
			res -= comb * 3;
			cout << "triple" << comb << endl;
		}
		else if (res % 2 == 0)
		{
			comb = res / 2;
			res -= comb * 2;
			cout << "double" << comb << endl;
		}
		else
		{
			if (res > 20)
			{
				int num1 = rand() % 22;
				if (num1 == 21)
					num1 = 25;
				cout << num1 << endl;
				res -= num1;
			}
			else
			{
				int temp = res;
				res -= temp;
				cout << temp << endl;
			}
		}
	}
	return res;
}
int k(int uk)
{
	int i;
	int r = 0;
	int wtf = 0;
	srand(time(NULL));
	while (!r)
	{
		int num1 = rand() % 22;
		if (num1 == 21)
			num1 = 25;
		int num2 = rand() % 22;
		if (num2 == 21)
			num2 = 25;
		int num3 = rand() % 22;
		if (num3 == 21)
			num3 = 25;
		if (num1 != 25 && num2 != 25 && num3 != 25)
		{
			for (i = 1; i <= 3; i++)
			{
				for (int j = 1; j <= 3; j++)
				{
					for (int z = 1; z <= 3; z++)
					{
						wtf = num1 * i + num2 * j + num3 * z;
						if (wtf == uk)
						{
							printf("uspjesno Combination: %d * %d + %d * %d + %d * %d = %d\n", num1, i, num2, j, num3, z, uk);
							r = 1;
							break;
						}
					}
					if (r)
						break;
				}
				if (r)
					break;
			}
		}
		else
		{
			if (num1 == 25 || num2 == 25 || num3 == 25) {
				for (int i = 1; i <= (num1 == 25 ? 2 : 3); ++i) {
					for (int j = 1; j <= (num2 == 25 ? 2 : 3); ++j) {
						for (int k = 1; k <= (num3 == 25 ? 2 : 3); ++k) {
							int wtf = num1 * i + num2 * j + num3 * k;
							if (wtf == uk) {
								printf("Combination: %d * %d + %d * %d + %d * %d = %d\n", num1, i, num2, j, num3, k, uk);
								r = 1;
								break;
							}
						}
						if (r) break;
					}
					if (r) break;
				}
			}
		}
	}
	return 0;
}