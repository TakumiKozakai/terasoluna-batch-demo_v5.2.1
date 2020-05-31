20200528_terasoluna-batch-demo_v5.2.1

1.概要及び背景
　terasoluna-batch-FW_v5.2.1を用いたデモを実施。
　業務利用のために学習。

2.実行環境
　OS		：MacOX High Sierra バージョン 10.13.6
　JDK		：openjdk-11.0.2
　IDE		：pleiades-2020-03-java-mac-jre_20200322
　Build Tool	：Apache Maven 3.6.3_1(HomeBrew導入)
　RDBMS		：PostgreSQL 12.2_1(HomeBrew導入)

3.実施内容
　・ファイル入力→DB出力：csvtodb
　・DB入力→ファイル出力：dbtocsv
　・ログ出力
　・処理時間計測
　　・100万件のUPDATE処理
　　　・チャンク（1000件コミット）	→360068 ms（360秒）
　　　・タスクレット（一括コミット）	→326503 ms（326秒）
　　・100万件のcsv作成処理
　　　・チャンク（1000件コミット）	→50893 ms(50秒)
　・シェルから実行
　・例外処理

4.利用時の留意事項

*.参照
　https://terasoluna-batch.github.io/guideline/current/ja/single_index.html#Ch09
