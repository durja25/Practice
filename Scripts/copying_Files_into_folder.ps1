$txt = "E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/accurate/accurate_common_58.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/air/air_changelog/air_common_release_51.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/air/air_changelog/air_common_release_58.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/aisino/aisino_allschema_35.19.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/aisino/aisino_common_32.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/aisino/aisino_common_32.25.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/aisino/aisino_common_35.19.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/al/al_common_release_32.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/al/al_common_release_33.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/allschema.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/cfs/cfs_changelog/cfs_common_43.12.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/common.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ei/ei_allschema_release_64.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ei/ei_allschema_release_66.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ei/ei_common_release_34.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ei/ei_common_release_44.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ei/ei_common_release_44.3.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ei/ei_common_release_45.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ei/ei_common_release_45.1.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ei/ei_common_release_63.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/emt/emt_changelog/emt_phoenix_common_release_51.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/emt/emt_changelog/emt_phoenix_common_release_52.6.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/emt/emt_changelog/emt_phoenix_common_release_56.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ff/ff_common_52.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ff/ff_common_53.3.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ff/ff_common_53.6.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_allschema_release32.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_allschema_release46.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_allschema_release52.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_allschema_release55.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_allschema_release66.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_common_release32.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_common_release49.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_common_release50.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_common_release51.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_common_release51.3.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_common_release52.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_common_release54.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_common_release55.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_common_release56.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_common_release58.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_common_release61.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_common_release65.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/finance/finance_changelog/finance_common_ss_sa_release34.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/legacy/legacy_common_32.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/legacy/legacy_common_34.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/mobility/mobility_common_release_41.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ocean/ocean_allschema_32.46.1.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ocean/ocean_common_44.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/ocean/ocean_common_57.9.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/product/product_allschema_43.13.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/product/product_common_35.0.xml
E:\Phoenix_WS\sql/src/main/sqlfiles/changelog/product/product_common_37.0.xml"

foreach ($orig_file in $txt -split '\r\n') {

    if ( $orig_file -match '^([^_]*)_([^_.]*)(.*)\.(.*)$' ) {
        $dir = $matches[2]
        $new_file = '{0}{1}.{2}' -f $matches[1], $matches[3], $matches[4]

        'Moving {0} to {1}\{2}' -f $orig_file, $dir, $new_file

        Copy-Item -Path $orig_file -Destination .

    }
    else {
        '{0} not processed' -f $orig_file        
    }

}