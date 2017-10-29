package com.djj.bat_algorithm;

import java.util.Random;

/*
 * 蝙蝠算法测试
 */
public class bat_algorithm {

	/**
	 * @param args
	 */
	public static int [] data={4,1,7,4,5};
	public static int boud_max=5;
	public static int boud_min=0;
	public static double A=0.3;//响度
	public static double r=0.4;//脉冲发射频率
	public static int N_gen=1000;//迭代次数
	public static int n=10;//种群数量
	public static int Fnew=100;
	public static double []fi=new double []{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};//搜索脉冲频率
	public static int fmin=0;
	public static int fmax=2;
	public static double []v=new double []{0,0,0,0,0,0,0,0,0,0};
	public static double []v_n=new double []{0,0,0,0,0,0,0,0,0,0};
	public static double []x=new double []{0,0,0,0,0,0,0,0,0,0};
	public static double []x_n=new double []{0,0,0,0,0,0,0,0,0,0};
	public static double best=4;
	public static int []Fitness=new int []{50,50,50,50,50,50,50,50,50,50};
	public static int res=100;
	public static int res_min=100;
	public static Random rand;//=new Random;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		find();
		//System.out.println("最优解"+res_min);

	}
	public static int Fun(int n){
		return n*n;
	}
	public static void update(int i){
		rand=new Random();
		fi[i]=fmin+(fmax-fmin)*rand.nextDouble();
		v[i]=v[i]+(x[i]-best)*fi[i];
		x[i]=x_n[i]+v[i];
		if(rand.nextDouble()>r){//随机扰动的条件
			double temp=x[i];
			x[i]=best+(rand.nextDouble()*2-1);
		}
		if(x[i]>4){//判断是否越界
			x[i]=4;
		}
		if(x[i]<0){//判断是否越界
			x[i]=0;
		}
		Fnew=Fun(data[(int)x[i]]);
		if(Fnew<Fitness[i]&&rand.nextDouble()<A){
			x_n[i]=x[i];
			Fitness[i]=Fnew;
		}
		if(Fnew<res_min){
			best=x[i];
			res_min=Fnew;
		}
	}
    public static void find(){
    	for(int i=0;i<N_gen;i++){
    		for(int j=0;j<n;j++){
    			update(j);
    		}
    		System.out.println("第"+i+"代"+res_min);
    	}
    }
}
