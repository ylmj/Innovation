package com.basic.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	public  static  Connection getConnection() {
		try {
			//1��������
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			System.out.println("���ݿ��������سɹ�");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ���������ʧ��");
			e.printStackTrace();
		}
		String user = "tech";//��¼oracle�ĵ�¼��
		String password = "root";
		//url jdbc:oracle:thin��ʾjdbc����oracle���ݿ��ͨѶЭ��
		//@localhost����
		//1521�����ϵĳ���˿�
		//orcl����˿��ϵ����ݿ�
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		Connection connection = null;
		try {
			 connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.out.println("����ʧ��");
			e.printStackTrace();
		}
		return connection;
	}
	public static void close(Connection connection ) {
		try {
			if (connection != null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement preparedStatement ) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(ResultSet resultSet ) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
