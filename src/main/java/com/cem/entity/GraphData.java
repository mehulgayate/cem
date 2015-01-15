package com.cem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import net.sf.json.JSONObject;

import com.evalua.entity.support.EntityBase;

@Entity
public class GraphData extends EntityBase{	

	public enum GraphType{
		WORDS, BLACK_LIST;
	}
	
	private Integer count=0;
	private Date date;
	private GraphType graphType=GraphType.WORDS;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}	
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public GraphType getGraphType() {
		return graphType;
	}
	public void setGraphType(GraphType graphType) {
		this.graphType = graphType;
	}
	public JSONObject toJSON(){
		JSONObject jsonObject =new JSONObject();		
		jsonObject.put("count", this.count);
		return jsonObject;
	}
	
	public static List<JSONObject> listToJSON(List<GraphData> graphDatas){
		List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
		
		for (GraphData graphData : graphDatas) {
			jsonObjects.add(graphData.toJSON());
		}
		
		return jsonObjects;
	}
	
		
}
