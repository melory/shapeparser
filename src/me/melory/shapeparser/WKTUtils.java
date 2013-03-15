/*
 * Copyright: Copyright (c) 2012 Kaliumn
 * 
 * @Description: 一些WKT的操作
 * 
 */

package me.melory.shapeparser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

/**
 * 类 <code> WKTUtil </code> 实现了对WKT的一些操作， 包括一些parse操作
 * 
 * @author <a href="mailto:imsrch@melory.me">melory</a>
 * @version v1.0.0
 * 
 */

public class WKTUtils {
	private WKTReader reader;
	private static final Log LOG = LogFactory.getLog(WKTUtils.class);

	/**
	 * 输入一个WKT的字符串，返回一个对应的Geometry对象
	 * 
	 * @param WKTString
	 *            WKT，以字符串表示
	 * @return Geometry对象
	 */
	public Geometry parseWKT(String WKTString) {
		Geometry result = null;
		reader = new WKTReader();
		try {
			result = reader.read(WKTString);
		} catch (ParseException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}
}
