package com.example.AnamolyDetectionApp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.HashMap;
import java.util.Map;

//import com.c2c.vo.AdPArtialAttributeUpdateFeatureFlag;
//import com.escrow.qps.QuikrPreferredSellerHelper;
//import com.escrow.util.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.jayway.jsonpath.internal.Utils;

//import models.c2c.AdDetails;
//import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class PostAdEventRequest {
	
	public static final String ATTRIBUTE_CONDITION = "Condition";
	
	private String id;

	private Long mTopicGlobalId;

	private Integer parentGlobalCategoryId;

	private String title;

	private String description;

	private String categoryName;

	private Long categoryId;

	private String areaNames;

	private Long areaId;

	private Long userId;

	private String userNickName;

	private Long createdTime;

	private String attributeData;

	private String attributeString;

	private String adStyle;

	private String image1;

	private String email;

	private Integer sourceDevice;

	private String location;

	private String mobileNumber;

	private String areaCityLevelId;

	private Object attribute_Reserved_Price;

	private String categoryNames;

	private String metaCategoryName;

	private String city_id;

	private Long firstCreated;

	private Integer soldStatus;

	private Integer usrPrivacy;

	private Map<String, String> mapForAttributeData;

	private Map<String, String> attributesMap;

	private Set<String> featureSet;




	public void setFeatureSet(Set<String> featureSet){
		this.featureSet = featureSet;
	}


	private AdMedia adMedia;

	@JsonIgnore
	private transient AdditionalInfo additionalInfo = new AdditionalInfo(); 
	
	class AdMedia {
		Object imageURLs;
	}

	public Object getImageUrls() {
		if (this.adMedia != null) {
			return adMedia.imageURLs;
		} else {
			return null;
		}
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getCategoryId() {
		return this.categoryId;
	}

	public void setTopicGlobalId(Long id) {
		this.mTopicGlobalId = id;
	}

	public Long getTopicGlobalId() {
		return this.mTopicGlobalId;
	}

	public void setAttributesMap(Map<String, String> attributesMap) {
		this.attributesMap = attributesMap;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAttributeData() {
		return attributeData;
	}

	public void setAttributeData(String attributeData) {
		this.attributeData = attributeData;
	}

	public String getAttributeString() {
		return attributeString;
	}

	public void setAttributeString(String attributeString) {
		this.attributeString = attributeString;
	}

	public Map<String, String> getMapForAttributeData() {
		mapForAttributeData = createAttributeMap(this.attributeData);
		return mapForAttributeData;
	}

	public void setMapForAttributeData(Map<String, String> mapForAttributeData) {
		this.mapForAttributeData = mapForAttributeData;
	}

	private Map<String, String> createAttributeMap(String attributeStr) {
		Map<String, String> attributesMap = new HashMap<String, String>();
		if (attributesMap != null) {
			if (attributeStr != null) {
				String[] attributes = attributeStr.split("\n");
				for (String attribute : attributes) {
					if (StringUtils.isNotBlank(attribute)) {
						String[] attr = attribute.split(":");
						attributesMap.put(attr[0], attr[1]);
					}
				}
			}
		}
		return attributesMap;
	}

	public Map<String, String> getAttributesMap() {
		if (attributesMap == null) {
			synchronized (this) {
				if (attributesMap == null) {
					attributesMap = createAttributeMap(this.attributeString);
				}
			}
		}
		return attributesMap;
	}


	public String getCondition(){
		String condition=null;
		Map<String,String> resultMap = getAttributesMap();
		if(resultMap!=null){
			condition = resultMap.get(ATTRIBUTE_CONDITION);
		}
		return condition;
	}
	
	



	public Integer getSourceDevice() {
		return sourceDevice;
	}

	public void setSourceDevice(Integer sourceDevice) {
		this.sourceDevice = sourceDevice;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdStyle() {
		return adStyle;
	}

	public void setAdStyle(String adStyle) {
		this.adStyle = adStyle;
	}

	public String getAreaCityLevelId() {
		return areaCityLevelId;
	}

	public String getCategoryName() {
		if (categoryName == null && StringUtils.isNotEmpty(categoryNames)) {
			String ar[] = categoryNames.split(",");
			categoryName = ar[1].trim();
			metaCategoryName = ar[0].trim();
		}
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public void setAreaCityLevelId(String areaCityLevelId) {
		this.areaCityLevelId = areaCityLevelId;
	}

	public long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}

	public Object getAttribute_Reserved_Price() {
		return attribute_Reserved_Price;
	}

	public void setAttribute_Reserved_Price(Object attribute_Reserved_Price) {
		this.attribute_Reserved_Price = attribute_Reserved_Price;
	}

	public String getMetaCategoryName() {
		if (metaCategoryName == null && StringUtils.isNotEmpty(categoryNames)) {
			String ar[] = categoryNames.split(",");
			categoryName = ar[1].trim();
			metaCategoryName = ar[0].trim();
		}
		return metaCategoryName;
	}

	

	public String getAttributeProductType() {
		return getAttributesMap().get("Product_Type");
	}


	
	public String getAttributeApplianceType() {
		return getAttributesMap().get("Appliance_Type");
	}

	public String getProductCategory() {
		if (StringUtils.isNotBlank(this.getAttributeApplianceType())) {
			return this.getAttributeApplianceType();
		} else if (StringUtils.isNotBlank(this.getAttributeProductType())) {
			return this.getAttributeProductType();
		} else {
			return null;
		}
	}

	public void setMetaCategoryName(String metaCategoryName) {
		this.metaCategoryName = metaCategoryName;
	}


	

	public Long getmTopicGlobalId() {
		return mTopicGlobalId;
	}

	public void setmTopicGlobalId(Long mTopicGlobalId) {
		this.mTopicGlobalId = mTopicGlobalId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAreaNames() {
		return areaNames;
	}

	public void setAreaNames(String areaNames) {
		this.areaNames = areaNames;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(String categoryNames) {
		this.categoryNames = categoryNames;
	}

	public void setParentGlobalCategoryId(Integer parentGlobalCategoryId) {
		this.parentGlobalCategoryId = parentGlobalCategoryId;
	}

	public Integer getParentGlobalCategoryId() {
		return this.parentGlobalCategoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}

	public Long getFirstCreated() {
		return firstCreated;
	}

	public void setFirstCreated(Long firstCreated) {
		this.firstCreated = firstCreated;
	}

	public Integer getSoldStatus() {
		return soldStatus;
	}

	public void setSoldStatus(Integer soldStatus) {
		this.soldStatus = soldStatus;
	}

	public Integer getUsrPrivacy() {
		return usrPrivacy;
	}

	public void setUsrPrivacy(Integer usrPrivacy) {
		this.usrPrivacy = usrPrivacy;
	}

	public String getMetaData() {
		StringBuilder metaData = new StringBuilder("ATTRSTRING[");
		metaData.append(this.attributeString).append("]");
		return metaData.toString();
	}

	
	
	
	/**
	 * @return the additionalInfo
	 */
	public final AdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	/**
	 * @param additionalInfo the additionalInfo to set
	 */
	public final void setAdditionalInfo(AdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}




	public static class AdditionalInfo {
		private boolean hasMobileInTitleAndDesc;

		/**
		 * @return the hasMobileInTitleAndDesc
		 */
		public final boolean isHasMobileInTitleAndDesc() {
			return hasMobileInTitleAndDesc;
		}

		/**
		 * @param hasMobileInTitleAndDesc the hasMobileInTitleAndDesc to set
		 */
		public final void setHasMobileInTitleAndDesc(boolean hasMobileInTitleAndDesc) {
			this.hasMobileInTitleAndDesc = hasMobileInTitleAndDesc;
		}
		
		
	}
}