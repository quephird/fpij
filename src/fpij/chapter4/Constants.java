package fpij.chapter4;

import java.util.Arrays;
import java.util.List;

public interface Constants {
    public static final List<Asset> ASSETS = Arrays.asList(
            new Asset(Asset.AssetType.BOND, 1000),
            new Asset(Asset.AssetType.BOND, 2000),
            new Asset(Asset.AssetType.STOCK, 3000),
            new Asset(Asset.AssetType.STOCK, 4000));
}
