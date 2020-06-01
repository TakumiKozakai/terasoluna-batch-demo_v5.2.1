#Info1データの入力・出力を行う

#shellディレクトリからシェル実行の想定
cd ../

#CSV→DBタスクレット
echo '＝＝＝入力処理開始＝＝＝'

java -cp 'lib/*:target/*' \
org.springframework.batch.core.launch.support.CommandLineJobRunner \
META-INF/jobs/csvtodb/Info1Tasklet.xml \
Info1Tasklet \
inputFile=files/input/input-info1-data.csv

echo '＝＝＝入力処理終了＝＝＝'
echo '処理結果:' $?

wait $!

#DB→CSVチャンク
echo '＝＝＝CSV出力処理開始＝＝＝'

java -cp 'lib/*:target/*' \
org.springframework.batch.core.launch.support.CommandLineJobRunner \
META-INF/jobs/dbtocsv/Info1Chunk.xml \
Info1Chunk \
outputFile=files/output/output-info1-data.csv

echo '＝＝＝CSV出力処理終了＝＝＝'
echo '処理結果:' $?

wait $!

#CSV→DBタスクレット
echo '＝＝＝入力処理開始＝＝＝'

java -cp 'lib/*:target/*' \
org.springframework.batch.core.launch.support.CommandLineJobRunner \
META-INF/jobs/csvtodb/Info2Tasklet.xml \
Info2Tasklet \
inputFile=files/input/input-info2-data.csv

echo '＝＝＝入力処理終了＝＝＝'
echo '処理結果:' $?

wait $!

#DB→CSVチャンク
echo '＝＝＝CSV出力処理開始＝＝＝'

java -cp 'lib/*:target/*' \
org.springframework.batch.core.launch.support.CommandLineJobRunner \
META-INF/jobs/dbtocsv/Info2Chunk.xml \
Info2Chunk \
outputFile=files/output/output-info2-data.csv

echo '＝＝＝CSV出力処理終了＝＝＝'
echo '処理結果:' $?
