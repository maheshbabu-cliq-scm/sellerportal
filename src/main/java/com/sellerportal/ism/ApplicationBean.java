/*
 *
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sellerportal.ism;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author:Binod Kumar
 * 
 * Modified for organization directory structure. General convention is to add the orgId in the end of every path. But thats still
 * a configuration can be changed based on the *-ant.properties 
 */
public class ApplicationBean implements Cloneable,Serializable{
    
    private static final long serialVersionUID = -6913972022251814606L;
	
	private static final Log LOGGER = LogFactory.getLog(ApplicationBean.class);
	
    private String baseImagesLocation;

    private String baseUploadImagesLocation;

    private String productImageLocation;
    
    private String attribIconLocation;

    private String itemImageLocation;

    private String categoryImageLocation;

    private String catalogueImageLocation;

    private String storeImageLocation;

    private String bannerImageLocation;
    
    private String mediaLocation;
    
    private String uploadBannerImageLocation;

    private String mailTemplatesUploadLocation;

    private String mailServerIP;

    private String fromAddress;
    
    private String noImagePath;

    private String bulkCsvPbiLocation;
    
    private String bulkXmlPbiLocation;
    
    private String bulkXsdPbiLocation;
    
    private String bulkXsdPotLocation;
     
    private String demThumbNailLocation;
    
    private String packageImageLocation;
    
    private String numRelatedProducts;
    
    private String numDiscountedProducts;
    
    private String restrictedCatalogue;
    
    private String defaultCatalogue;
    
    private String eshopStylesTargetLocation;

	private String masterCssUploadLocation;
	
	private String mastersCssTargetLocation;
    
    private String pageTitle;
    
    private String checkStockQuantity; 
    
    private String stockQuantityCheckLevel;
    
    private String stockQuantityReduction;
    
    private String inventoryAlert;
    
    private String UPSAccessRequestfileLocation;
    
    private String UPSRateRequestfileLocation;

    private String defaultCss; 
    
    private String entityImageLocation;
    
    private String boutiqueImageLocation;
    
    private String campaignImageLocation;
    
    
    
    /*private boolean currency ;
    private String  currencyCode ;
    private String  currencySymbol ;*/
    
    public String getBoutiqueImageLocation() {
		return boutiqueImageLocation;
	}

	public void setBoutiqueImageLocation(String boutiqueImageLocation) {
		this.boutiqueImageLocation = boutiqueImageLocation;
	}

	private String productFeedPropertiesLocation;
    
    private String rssFeedFileSavingLocation;
    /**
	 * @return Returns the rssFeedFileSavingLocation.
	 */
	public String getRssFeedFileSavingLocation() {
		return rssFeedFileSavingLocation;
	}

	/**
	 * @param rssFeedFileSavingLocation The rssFeedFileSavingLocation to set.
	 */
	public void setRssFeedFileSavingLocation(String rssFeedFileSavingLocation) {
		this.rssFeedFileSavingLocation = rssFeedFileSavingLocation;
	}

	/**
	 * @return Returns the productFeedPropertiesLocation.
	 */
	public String getProductFeedPropertiesLocation() {
		return productFeedPropertiesLocation;
	}

	/**
	 * @param productFeedPropertiesLocation The productFeedPropertiesLocation to set.
	 */
	public void setProductFeedPropertiesLocation(
			String productFeedPropertiesLocation) {
		this.productFeedPropertiesLocation = productFeedPropertiesLocation;
	}

	/**
	 * @return Returns the inventoryAlert.
	 */
	public String getInventoryAlert() {
		return inventoryAlert;
	}

	/**
	 * @param inventoryAlert The inventoryAlert to set.
	 */
	public void setInventoryAlert(String inventoryAlert) {
		this.inventoryAlert = inventoryAlert;
	}

	/**
	 * @return Returns the pageTitle.
	 */
	public String getPageTitle() {
		return pageTitle;
	}

	/**
	 * @param pageTitle The pageTitle to set.
	 */
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}


   /**
	 * @return Returns the numDiscountedProducts.
	 */
	public String getNumDiscountedProducts() {
		return numDiscountedProducts;
	}

	/**
	 * @param numDiscountedProducts The numDiscountedProducts to set.
	 */
	public void setNumDiscountedProducts(String numDiscountedProducts) {
		this.numDiscountedProducts = numDiscountedProducts;
	}

	/**
	 * @return Returns the numRelatedProducts.
	 */
	public String getNumRelatedProducts() {
		return numRelatedProducts;
	}

	/**
	 * @param numRelatedProducts The numRelatedProducts to set.
	 */
	public void setNumRelatedProducts(String numRelatedProducts) {
		this.numRelatedProducts = numRelatedProducts;
	}

	public String getUploadBannerImageLocation() {
        return uploadBannerImageLocation;
    }

    public void setUploadBannerImageLocation(String uploadBannerImageLocation) {
        this.uploadBannerImageLocation = uploadBannerImageLocation;
    }

    public String getBannerImageLocation() {
        return bannerImageLocation;
    }

    public void setBannerImageLocation(String bannerImageLocation) {
        this.bannerImageLocation = bannerImageLocation;
    }

    public String getBaseImagesLocation() {
        return baseImagesLocation;
    }

    public void setBaseImagesLocation(String baseImagesLocation) {
        this.baseImagesLocation = baseImagesLocation;
    }

    public String getCatalogueImageLocation() {
        return catalogueImageLocation;
    }

    public void setCatalogueImageLocation(String catalogueImageLocation) {
        this.catalogueImageLocation = catalogueImageLocation;
    }

    public String getCategoryImageLocation() {
        return categoryImageLocation;
    }

    public void setCategoryImageLocation(String categoryImageLocation) {
        this.categoryImageLocation = categoryImageLocation;
    }

    public String getItemImageLocation() {
        return itemImageLocation;
    }

    public void setItemImageLocation(String itemImageLocation) {
        this.itemImageLocation = itemImageLocation;
    }

    public String getProductImageLocation() {
        return productImageLocation;
    }

    public void setProductImageLocation(String productImageLocation) {
        this.productImageLocation = productImageLocation;
    }

    public String getStoreImageLocation() {
        return storeImageLocation;
    }

    public void setStoreImageLocation(String storeImageLocation) {
        this.storeImageLocation = storeImageLocation;
    }

    public String getBaseUploadImagesLocation() {
        return baseUploadImagesLocation;
    }

    public void setBaseUploadImagesLocation(String baseUploadImagesLocation) {
        this.baseUploadImagesLocation = baseUploadImagesLocation;
    }

    

    /**
     * @return Returns the mailTemplatesUploadLocation.
     */
    public String getMailTemplatesUploadLocation() {
        return mailTemplatesUploadLocation;
    }

    /**
     * @param mailTemplatesUploadLocation
     *            The mailTemplatesUploadLocation to set.
     */
    public void setMailTemplatesUploadLocation(
            String mailTemplatesUploadLocation) {
        this.mailTemplatesUploadLocation = mailTemplatesUploadLocation;
    }

    /**
     * @return Returns the fromAddress.
     */
    public String getFromAddress() {
        return fromAddress;
    }

    /**
     * @param fromAddress
     *            The fromAddress to set.
     */
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    /**
     * @return Returns the mailServerIP.
     */
    public String getMailServerIP() {
        return mailServerIP;
    }

    /**
     * @param mailServerIP
     *            The mailServerIP to set.
     */
    public void setMailServerIP(String mailServerIP) {
        this.mailServerIP = mailServerIP;
    }

    //Permanent path where templates will be uploaded
    private String templatesUploadPath = null;

    //Path where templates will be copied relative to WEB ROOT.
    private String templatesPath = null;

    /**
     * @return Returns the templatesPath.
     */
    public String getTemplatesPath() {
        return templatesPath;
    }

    /**
     * @param templatesPath
     *            The templatesPath to set.
     */
    public void setTemplatesPath(String templatesPath) {
        this.templatesPath = templatesPath;
    }

    /**
     * @return Returns the templatesUploadPath.
     */
    public String getTemplatesUploadPath() {
        return templatesUploadPath;
    }

    /**
     * @param templatesUploadPath
     *            The templatesUploadPath to set.
     */
    public void setTemplatesUploadPath(String templatesUploadPath) {
        this.templatesUploadPath = templatesUploadPath;
    }

	/**
	 * @return Returns the noImagePath.
	 */
	public String getNoImagePath() {
		return noImagePath;
	}

	/**
	 * @param noImagePath The noImagePath to set.
	 */
	public void setNoImagePath(String noImagePath) {
		this.noImagePath = noImagePath;
	}

    public String getBulkCsvPbiLocation() {
        return bulkCsvPbiLocation;
    }

    public void setBulkCsvPbiLocation(String bulkCsvPbiLocation) {
        this.bulkCsvPbiLocation = bulkCsvPbiLocation;
    }

    public String getBulkXmlPbiLocation() {
        return bulkXmlPbiLocation;
    }

    public void setBulkXmlPbiLocation(String bulkXmlPbiLocation) {
        this.bulkXmlPbiLocation = bulkXmlPbiLocation;
    }

    public String getBulkXsdPbiLocation() {
        return bulkXsdPbiLocation;
    }

    public void setBulkXsdPbiLocation(String bulkXsdPbiLocation) {
        this.bulkXsdPbiLocation = bulkXsdPbiLocation;
    }

    /**
     * @return Returns the packageImageLocation.
     */
    public String getPackageImageLocation() {
        return packageImageLocation;
    }
    /**
     * @param packageImageLocation The packageImageLocation to set.
     */
    public void setPackageImageLocation(String packageImageLocation) {
        this.packageImageLocation = packageImageLocation;
    }
    /**
     * @return Returns the demThumbNailLocation.
     */
    public String getDemThumbNailLocation() {
        return demThumbNailLocation;
    }
    /**
     * @param demThumbNailLocation The demThumbNailLocation to set.
     */
    public void setDemThumbNailLocation(String demThumbNailLocation) {
        this.demThumbNailLocation = demThumbNailLocation;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    /*public Object clone(){
    	try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			LOGGER.info("Message :: "+e.toString() +" Cause :: "+e.getCause());
		}
		return null;
    }*/

	public String getMediaLocation() {
		return mediaLocation;
	}

	public void setMediaLocation(String mediaLocation) {
		this.mediaLocation = mediaLocation;
	}

	/**
	 * @return Returns the bulkXsdPotLocation.
	 */
	public String getBulkXsdPotLocation() {
		return bulkXsdPotLocation;
	}

	/**
	 * @param bulkXsdPotLocation The bulkXsdPotLocation to set.
	 */
	public void setBulkXsdPotLocation(String bulkXsdPotLocation) {
		this.bulkXsdPotLocation = bulkXsdPotLocation;
	}

    public String getRestrictedCatalogue() {
        return restrictedCatalogue;
    }

    public void setRestrictedCatalogue(String restrictedCatalogue) {
        this.restrictedCatalogue = restrictedCatalogue;
    }

	/**
	 * @return Returns the defaultCatalogue.
	 */
	public String getDefaultCatalogue() {
		return defaultCatalogue;
	}

	/**
	 * @param defaultCatalogue The defaultCatalogue to set.
	 */
	public void setDefaultCatalogue(String defaultCatalogue) {
		this.defaultCatalogue = defaultCatalogue;
	}
    
	/**
	 * @return Returns the eshopStylesTargetLocation.
	 */
	public String getEshopStylesTargetLocation() {
		return eshopStylesTargetLocation;
	}
	/**
	 * @param eshopStylesTargetLocation The eshopStylesTargetLocation to set.
	 */
	public void setEshopStylesTargetLocation(String eshopStylesTargetLocation) {
		this.eshopStylesTargetLocation = eshopStylesTargetLocation;
	}
	/**
	 * @return Returns the masterCssUploadLocation.
	 */
	public String getMasterCssUploadLocation() {
		return masterCssUploadLocation;
	}
	/**
	 * @param masterCssUploadLocation The masterCssUploadLocation to set.
	 */
	public void setMasterCssUploadLocation(String masterCssUploadLocation) {
		this.masterCssUploadLocation = masterCssUploadLocation;
	}
	/**
	 * @return Returns the mastersCssTargetLocation.
	 */
	public String getMastersCssTargetLocation() {
		return mastersCssTargetLocation;
	}
	/**
	 * @param mastersCssTargetLocation The mastersCssTargetLocation to set.
	 */
	public void setMastersCssTargetLocation(String mastersCssTargetLocation) {
		this.mastersCssTargetLocation = mastersCssTargetLocation;
	}

	

	/**
	 * @return Returns the checkStockQuantity.
	 */
	public String getCheckStockQuantity() {
		return checkStockQuantity;
	}

	/**
	 * @param checkStockQuantity The checkStockQuantity to set.
	 */
	public void setCheckStockQuantity(String checkStockQuantity) {
		this.checkStockQuantity = checkStockQuantity;
	}

	public String getAttribIconLocation() {
		return attribIconLocation;
	}

	public void setAttribIconLocation(String attribIconLocation) {
		this.attribIconLocation = attribIconLocation;
	}

	public String getUPSAccessRequestfileLocation() {
		return UPSAccessRequestfileLocation;
	}

	public void setUPSAccessRequestfileLocation(String accessRequestfileLocation) {
		UPSAccessRequestfileLocation = accessRequestfileLocation;
	}

	public String getUPSRateRequestfileLocation() {
		return UPSRateRequestfileLocation;
	}

	public void setUPSRateRequestfileLocation(String rateRequestfileLocation) {
		UPSRateRequestfileLocation = rateRequestfileLocation;
	}

	public boolean isCurrency() {
		return Application.instance().isAppCurrency();
	}

	public String getCurrencyCode() {
		return Application.instance().getAppCurrencyCode();
	}

	public String getCurrencySymbol() {
		return Application.instance().getAppCurrencySymbol();
	}

	/**
	 * @return Returns the stockQuantityCheckLevel.
	 */
	public String getStockQuantityCheckLevel() {
		return stockQuantityCheckLevel;
	}

	/**
	 * @param stockQuantityCheckLevel The stockQuantityCheckLevel to set.
	 */
	public void setStockQuantityCheckLevel(String stockQuantityCheckLevel) {
		this.stockQuantityCheckLevel = stockQuantityCheckLevel;
	}

	/**
	 * @return Returns the stockQuantityReduction.
	 */
	public String getStockQuantityReduction() {
		return stockQuantityReduction;
	}

	/**
	 * @param stockQuantityReduction The stockQuantityReduction to set.
	 */
	public void setStockQuantityReduction(String stockQuantityReduction) {
		this.stockQuantityReduction = stockQuantityReduction;
	}

	
	public String getDefaultCss() {
		return defaultCss;
	}
	
	public void setDefaultCss(String defaultCss) {
		this.defaultCss = defaultCss;
	}

	public String getEntityImageLocation() {
		return entityImageLocation;
	}

	public void setEntityImageLocation(String entityImageLocation) {
		this.entityImageLocation = entityImageLocation;
	}

	public String getCampaignImageLocation() {
		return campaignImageLocation;
	}

	public void setCampaignImageLocation(String campaignImageLocation) {
		this.campaignImageLocation = campaignImageLocation;
	}
	
	
	
}