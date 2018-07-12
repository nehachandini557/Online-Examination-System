package com.svecw.oes.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.svecw.oes.dto.Data;

public class JSONUtility {
	Gson gson = new Gson();

	public Data convertJSONtoJava(String json) {
		Data data = null;
		try {
			data = gson.fromJson(json, Data.class);
		} catch (JsonSyntaxException e) {
			System.out.println(e);
		}
		return data;
	}

	public String convertJavatoJSON(Data data) {
		return gson.toJson(data);
	}

	public List<Data> convertJSONtoJavaList(String json) {
		List<Data> optionsList = new ArrayList<>();
		try {
			Data[] data = gson.fromJson(json, Data[].class);

			for (Data s : data) {
				optionsList.add(s);
			}
		} catch (JsonSyntaxException e) {
			System.out.println(e);
		}
		return optionsList;

	}

	public String convertJavaListtoJSON(List<Data> data) {
		return gson.toJson(data);

	}

}
