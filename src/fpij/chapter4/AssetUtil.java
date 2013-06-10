package fpij.chapter4;

import java.util.List;
import java.util.function.Predicate;

// There is another deviation from the book here, as of JDK8 build 92:
// I needed to call mapToInt() instead of map().

public class AssetUtil {
    public static void main(String[] args) {
        jdk8Lame();
        jdk8Uber();
    }

    private static void jdk8Lame() {
        System.out.println("Totalling assets the lame way...");
        System.out.println("All assets: " + totalAssetValues(Constants.ASSETS));
        System.out.println("Bonds only: " + totalBondValues(Constants.ASSETS));
        System.out.println("Stocks only: " + totalStockValues(Constants.ASSETS));
    }

    public static int totalAssetValues(final List<Asset> assets) {
        return assets
                .stream()
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static int totalBondValues(final List<Asset> assets) {
        return assets
                .stream()
                .filter(asset -> asset.getType() == Asset.AssetType.BOND)
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static int totalStockValues(final List<Asset> assets) {
        return assets
                .stream()
                .filter(asset -> asset.getType() == Asset.AssetType.STOCK)
                .mapToInt(Asset::getValue)
                .sum();
    }

    private static void jdk8Uber() {
        System.out.println("Totalling assets the uber way...");
        System.out.println("All assets: " + totalAssetValues(Constants.ASSETS, asset -> true));
        System.out.println("Bonds only: " + totalAssetValues(Constants.ASSETS, asset -> asset.getType() == Asset.AssetType.BOND));
        System.out.println("Stocks only: " + totalAssetValues(Constants.ASSETS, asset -> asset.getType() == Asset.AssetType.STOCK));
    }

    public static int totalAssetValues(final List<Asset> assets, final Predicate<Asset> assetSelector) {
        return assets
                .stream()
                .filter(assetSelector)
                .mapToInt(Asset::getValue)
                .sum();
    }
}

