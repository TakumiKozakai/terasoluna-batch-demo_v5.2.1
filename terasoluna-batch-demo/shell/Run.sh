#Info1データの入力・出力を行う

#shellディレクトリからシェル実行の想定
cd ../

#CSV→DBタスクレット
echo '＝＝＝入力処理開始＝＝＝'

java -cp 'lib/*:target/*' \
org.springframework.batch.core.launch.support.CommandLineJobRunner \
META-INF/jobs/csvtodb/TaskletInfo1.xml \
TaskletInfo1 \
inputFile=files/input/input-info1-data.csv

echo '＝＝＝入力処理終了＝＝＝'
echo '処理結果:' $?

wait $!

#DB→CSVチャンク
echo '＝＝＝CSV出力処理開始＝＝＝'

java -cp 'lib/*:target/*' \
org.springframework.batch.core.launch.support.CommandLineJobRunner \
META-INF/jobs/dbtocsv/ChunkInfo1.xml \
ChunkInfo1 \
outputFile=files/output/output-info1-data.csv

echo '＝＝＝CSV出力処理終了＝＝＝'
echo '処理結果:' $?

wait $!

#CSV→DBタスクレット
echo '＝＝＝入力処理開始＝＝＝'

java -cp 'lib/*:target/*' \
org.springframework.batch.core.launch.support.CommandLineJobRunner \
META-INF/jobs/csvtodb/TaskletInfo2.xml \
TaskletInfo2 \
inputFile=files/input/input-info2-data.csv

echo '＝＝＝入力処理終了＝＝＝'
echo '処理結果:' $?

wait $!

#DB→CSVチャンク
echo '＝＝＝CSV出力処理開始＝＝＝'

java -cp 'lib/*:target/*' \
org.springframework.batch.core.launch.support.CommandLineJobRunner \
META-INF/jobs/dbtocsv/ChunkInfo2.xml \
ChunkInfo2 \
outputFile=files/output/output-info2-data.csv

echo '＝＝＝CSV出力処理終了＝＝＝'
echo '処理結果:' $?
