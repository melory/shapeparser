/*
 * Copyright: Copyright (c) 2012 Kaliumn
 * 
 * @Description: WKB的相关操作
 * 
 */

package me.melory.shapeparser;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBReader;
import com.vividsolutions.jts.io.WKBWriter;

/**
 * 类 <code> WKBUtils </code> 主要实现了一些对WKB常用处理的实现
 * 
 * @author <a href="mailto:imsrch@melory.me">melory</a>
 * @version v1.0.0
 * 
 */

public class WKBUtils {
	private static WKBWriter writer = new WKBWriter();
	private static WKBReader reader = new WKBReader();
	
	private static final Log LOG = LogFactory.getLog(WKBUtils.class);

	/**
	 * 通过Geometry对象返回WKB
	 * 
	 * @param geometry
	 *            Geometry对象
	 * @return WKB
	 */
	public byte[] geomtry2WKB(Geometry geometry) {
		return writer.write(geometry);
	}

	/**
	 * 将WKB转换成对应的Geometry对象
	 * 
	 * @param WKBBytes
	 *            WB
	 * @return Geometry对象
	 */
	public Geometry parseWKB(byte[] WKBBytes) {
		Geometry result = null;
		try {
			result = reader.read(WKBBytes);
		} catch (ParseException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

}
