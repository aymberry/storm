package STDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.JDBCUtil;
import JDBC.POOLUtil;
import STSql.GoodsSql;
import STVo.GoodsTagVo;
import STVo.GoodsVo;

public class GoodsDao
{
		Connection				connection;
		Statement					statement;
		PreparedStatement	preparedStatement;
		JDBCUtil					db;
		
		public GoodsDao()
		{
			db					=	new JDBCUtil();
			connection	=	db.getCON();
		}
		
		/**
		 * 상품 리스트를 받아오는 Dao함수
		 * @return
		 */
		public ArrayList	getGoodsList()
		{
			ArrayList list	=	new ArrayList();
			
			//String sql	=	GoodsSql.getSQL(GoodsSql.ALL_GOODS_LIST);
			String sql	=	GoodsSql.getSQL(GoodsSql.ALL_GOODS_LIST);

			statement	=	db.getSTMT(connection);
			
			try
			{
				ResultSet	rs	=	statement.executeQuery(sql);
				
				while(rs.next())
				{
					GoodsVo	vo		=	new GoodsVo();
					//GoodsTypeDao dao = new GoodsTypeDao();
					
					vo.no				=	rs.getInt("no");
					vo.name			=	rs.getString("name");
					vo.type_no		=	rs.getInt("TYPE_NO");
					vo.registDate	=	rs.getDate("REGISTDATE");
					vo.releaseDate	=	rs.getDate("RELEASEDATE");
					vo.price				=	rs.getInt("PRICE");
					vo.smallText		=	rs.getString("SMALLTEXT");
					vo.bigText			=	rs.getString("BIGTEXT");
					vo.installFileName
											=	rs.getString("INSTALLFILENAME");
					vo.os_name		=	rs.getString("OS_NAME");
					vo.type				=	rs.getString("TYPE");
					vo.img_name = rs.getString("imgname");
					
					System.out.println("DAO_VO.name="+vo.name);
					// 상품의 타입을 받아온다
							
					
					//상품의 태그를 받아온다 (ArrayList)
					GoodsTagDao tag_dao	=	new GoodsTagDao();
					ArrayList<GoodsTagVo>	tag_vo	=	tag_dao.getTags(vo.no);
					vo.tag_list	=	tag_vo;
					for(GoodsTagVo o : tag_vo)
						System.out.println("DEBUG..:"+o.tag_no+"\t"+o.tag_name);
					list.add(vo);
				}
			}
			catch (Exception e) 
			{
				System.out.println("SQL실행 에러-GoodsDao-getGoodsList\t"+e);
			}
			
			return list;
		}
		
		public void close() 
		{
			db.close(statement);
			db.close(preparedStatement);
			//db.close(connection);
		}
		
		/**
		 * 특정 상품에 대해 상세 정보를 받아오는 Dao함수
		 * @param goods_no
		 * @return
		 */
		public GoodsVo getGoodsDetail(int goods_no) 
		{
			System.out.println("[GoodsDao->getGoodsDetail(int goods_no)]:"+goods_no);

			GoodsVo vo = new GoodsVo();
			String sql = GoodsSql.getSQL(GoodsSql.GET_GOODS_DETAIL);
			
			preparedStatement	=	db.getPSTMT(connection, sql);
			
			try
			{
				
				System.out.println("[GoodsDao->getGoodsDetail(int goods_no)]:try_block");
				preparedStatement.setInt(1, goods_no);
				ResultSet	rs	=	preparedStatement.executeQuery();
				rs.next();
				//필드값들을 채움
				vo.no			=	rs.getInt("no");
				vo.name			=	rs.getString("name");
				vo.type_no		=	rs.getInt("TYPE_NO");
				vo.registDate	=	rs.getDate("REGISTDATE");
				vo.releaseDate	=	rs.getDate("RELEASEDATE");
				vo.price		=	rs.getInt("price");
				vo.smallText	=	rs.getString("smalltext");
				vo.bigText		=	rs.getString("bigText");
				vo.installFileName=	rs.getString("installfilename");
				vo.os_name		=	rs.getString("os_name");
				vo.img_name = rs.getString("imgname");
				vo.type			=	new GoodsTypeDao().getGoodsType(vo.no);
				vo.tag_list		=	new GoodsTagDao().getTags(vo.no);
				System.out.println("DAO:"+vo.name);
			}
			catch (Exception e) 
			{
				System.out.println("[GoodsDao->getGoodsDetail(int goods_no)]:ERR("+e+")");
			}
			
			//db.close(preparedStatement);
			return vo;
		}
		
		
		public	ArrayList	getRecentlyReleasedTop3()
		{
			ArrayList	list	=	new ArrayList();
			
			String sql	=	GoodsSql.getSQL(GoodsSql.GET_RRECENTLY_RELEASED);
			
			statement	=	db.getSTMT(connection);
			try
			{
				ResultSet rs = statement.executeQuery(sql);
				
				while(rs.next())
				{
					GoodsVo	vo		=	new GoodsVo();
					//GoodsTypeDao dao = new GoodsTypeDao();
					
					vo.no				=	rs.getInt("no");
					vo.name			=	rs.getString("name");
					vo.type_no		=	rs.getInt("TYPE_NO");
					vo.registDate	=	rs.getDate("REGISTDATE");
					vo.releaseDate	=	rs.getDate("RELEASEDATE");
					vo.price				=	rs.getInt("PRICE");
					vo.smallText		=	rs.getString("SMALLTEXT");
					vo.bigText			=	rs.getString("BIGTEXT");
					vo.installFileName
											=	rs.getString("INSTALLFILENAME");
					vo.os_name		=	rs.getString("OS_NAME");
					vo.type				=	rs.getString("TYPE");
					
					System.out.println("DAO_VO.name="+vo.name);
					// 상품의 타입을 받아온다
							
					
					//상품의 태그를 받아온다 (ArrayList)
					GoodsTagDao tag_dao	=	new GoodsTagDao();
					ArrayList<GoodsTagVo>	tag_vo	=	tag_dao.getTags(vo.no);
					vo.tag_list	=	tag_vo;
					for(GoodsTagVo o : tag_vo)
						System.out.println("DEBUG..:"+o.tag_no+"\t"+o.tag_name);
					list.add(vo);
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			
			return list;
		}
		
		public boolean	getReviewWritable(int goods_no, int user_no)
		{
			boolean result	=	false;			
			String sql	=	GoodsSql.getSQL(GoodsSql.GET_REVIEW_WRITABLE);
			System.out.println(goods_no + "\t"+ user_no);			
			try
			{
				preparedStatement	=	db.getPSTMT(connection, sql);
				preparedStatement.setInt(1, goods_no);
				preparedStatement.setInt(2, user_no);
				
				ResultSet rs = preparedStatement.executeQuery();
				rs.next();
				String writable = rs.getString("WRITABLE");
				
				System.out.println("WRITABLE IS : "+writable);
				if(writable.equals("Y"))
					return true;
			}
			catch (Exception e) 
			{
				System.out.println("[GoodsDao.getReviewWritable(int goods_no, int user_no)] : "+e);
				e.printStackTrace();
			}
			return result;
		}
		public ArrayList getRecentList(){
			ArrayList list	=	new ArrayList();

		String sql	=	GoodsSql.getSQL(GoodsSql.GET_RECENTLIST);

		statement	=	db.getSTMT(connection);
		
		try
		{
			ResultSet	rs	=	statement.executeQuery(sql);
			
			while(rs.next())
			{
				GoodsVo	vo		=	new GoodsVo();

				
				vo.no				=	rs.getInt("no");
				vo.name			=	rs.getString("name");
				vo.type_no		=	rs.getInt("TYPE_NO");
				vo.registDate	=	rs.getDate("REGISTDATE");
				vo.releaseDate	=	rs.getDate("RELEASEDATE");
				vo.price				=	rs.getInt("PRICE");
				vo.smallText		=	rs.getString("SMALLTEXT");
				vo.bigText			=	rs.getString("BIGTEXT");
				vo.installFileName
										=	rs.getString("INSTALLFILENAME");
				vo.os_name		=	rs.getString("OS_NAME");
				vo.type				=	rs.getString("TYPE");
				vo.img_name = rs.getString("imgname");
				
				System.out.println("DAO_VO.name="+vo.name);

				GoodsTagDao tag_dao	=	new GoodsTagDao();
				ArrayList<GoodsTagVo>	tag_vo	=	tag_dao.getTags(vo.no);
				vo.tag_list	=	tag_vo;
				for(GoodsTagVo o : tag_vo)
					System.out.println("DEBUG..:"+o.tag_no+"\t"+o.tag_name);
				list.add(vo);
			}
		}
		catch (Exception e) 
		{
			System.out.println("SQL실행 에러-GoodsDao-RecentList\t"+e);
		}
		
		return list;
	}
	public ArrayList getRandomList(){
		ArrayList list	=	new ArrayList();

	String sql	=	GoodsSql.getSQL(GoodsSql.GET_RANDOMLIST);

	statement	=	db.getSTMT(connection);
	
	try
	{
		ResultSet	rs	=	statement.executeQuery(sql);
		
		while(rs.next())
		{
			GoodsVo	vo		=	new GoodsVo();

			
			vo.no				=	rs.getInt("no");
			vo.name			=	rs.getString("name");
			vo.type_no		=	rs.getInt("TYPE_NO");
			vo.registDate	=	rs.getDate("REGISTDATE");
			vo.releaseDate	=	rs.getDate("RELEASEDATE");
			vo.price				=	rs.getInt("PRICE");
			vo.smallText		=	rs.getString("SMALLTEXT");
			vo.bigText			=	rs.getString("BIGTEXT");
			vo.installFileName
									=	rs.getString("INSTALLFILENAME");
			vo.os_name		=	rs.getString("OS_NAME");
			vo.img_name = rs.getString("imgname");
			
			System.out.println("DAO_VO.name="+vo.name);

			GoodsTagDao tag_dao	=	new GoodsTagDao();
			ArrayList<GoodsTagVo>	tag_vo	=	tag_dao.getTags(vo.no);
			vo.tag_list	=	tag_vo;
			for(GoodsTagVo o : tag_vo)
				System.out.println("DEBUG..:"+o.tag_no+"\t"+o.tag_name);
			list.add(vo);
		}
	}
	catch (Exception e) 
	{
		System.out.println("SQL실행 에러-GoodsDao-RANDOMList\t"+e);
	}
	
	return list;
}
}
