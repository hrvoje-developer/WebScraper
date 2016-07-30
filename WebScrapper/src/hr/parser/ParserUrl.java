package hr.parser;

public class ParserUrl {

	public String uRlParser;

	public String getUrl() {
		return uRlParser;
	}

	public void setUrl(String uRl) {
		uRlParser = uRl;
	}

	public void glueCarUrl(String carPriceMin, String carPriceMax, String carYearMin, String carYearMax,
			String carFuelType, String kwMin, String kwMax, String kmMin, String kmMax) {
		String glueUrl = "http://www.njuskalo.hr/?ctl=browse_ads&page=1&sort=cheap&categoryId=7&modelId=&modelId_level_0=0&price%5Bmin%5D="
				+ carPriceMin + "&price%5Bmax%5D=" + carPriceMax
				+ "&onlyFullPrice=1&locationId=&locationId_level_0=0&yearManufacturedMin=" + carYearMin
				+ "&yearManufacturedMax=" + carYearMax + "&adsWithImages=1&fuelTypeId=" + carFuelType
				+ "&fuelHasLpg=&motorSizeMin=&motorSizeMax=&motorPowerMin=" + kwMin + "&motorPowerMax=" + kwMax
				+ "&mileageMin=" + kmMin + "&mileageMax=" + kmMax
				+ "&airConditionTypeId=0&transmissionTypeId=0&gearNumberId=0";
		System.out.println(glueUrl);
	}
}
