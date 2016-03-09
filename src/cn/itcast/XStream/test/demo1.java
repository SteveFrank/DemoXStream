package cn.itcast.XStream.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import cn.itcast.XStream.bean.City;
import cn.itcast.XStream.bean.Province;

/**
 * 演示XStream的相关作用
 * @author 杨谦
 * @date 2015-9-6 下午10:41:20
 *
 */
public class demo1 {
	public List<Province<City>> getProvinceList(){
		List<Province<City>> ProvinceList = new ArrayList<Province<City>>();
		Province<City> province1 = new Province<City>();
		province1.setName("四川");
		province1.addCity(new City("成都","chengdu"));
		province1.addCity(new City("广汉","guanghan"));
		Province<City> province2 = new Province<City>();
		province2.setName("重庆");
		province2.addCity(new City("江北","jiangbei"));
		province2.addCity(new City("沙坪坝","shapingba"));
		ProvinceList.add(province1);
		ProvinceList.add(province2);
		return ProvinceList;
	}
	@Test
	public void fun1(){
		XStream xs = new XStream();
		String str = xs.toXML(getProvinceList());
		System.out.println(str);
	}
	/**
	 * 别名（alias）
	 */
	@Test
	public void fun2(){
		List<Province<City>> proList = getProvinceList();
		XStream xs = new XStream();
		
		xs.alias("china", List.class);
		xs.alias("province",Province.class);
		xs.alias("city",City.class);
		String str = xs.toXML(proList);
		System.out.println(str);
	}
	@Test
	/**
	 * 设置属性
	 */
	public void fun3(){
		List<Province<City>> proList = getProvinceList();
		XStream xs = new XStream();
		
		xs.alias("china", List.class);
		xs.alias("province",Province.class);
		xs.alias("city",City.class);
		xs.useAttributeFor(Province.class,"name");
		String str = xs.toXML(proList);
		System.out.println(str);
	}
	@Test
	/**
	 * 移除无用属性
	 */
	public void fun4(){
		List<Province<City>> proList = getProvinceList();
		XStream xs = new XStream();
		
		xs.alias("china", List.class);
		xs.alias("province",Province.class);
		xs.alias("city",City.class);
		xs.useAttributeFor(Province.class,"name");
		xs.addImplicitCollection(Province.class, "cities");
		String str = xs.toXML(proList);
		System.out.println(str);
	}
	@Test
	/**
	 * 让类成员不生成对应的XML元素
	 */
	public void fun5(){
		List<Province<City>> proList = getProvinceList();
		XStream xs = new XStream();
		
		xs.alias("china", List.class);
		xs.alias("province",Province.class);
		xs.alias("city",City.class);
		xs.useAttributeFor(Province.class,"name");
		xs.addImplicitCollection(Province.class, "cities");
		xs.omitField(City.class, "description");
		String str = xs.toXML(proList);
		System.out.println(str);
	}
}
