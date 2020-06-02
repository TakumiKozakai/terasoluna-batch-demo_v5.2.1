#Info1データの入力・出力を行う

#shellディレクトリからシェル実行の想定
cd ../

echo '＝＝＝Info1＝＝＝'
#CSV→DBタスクレット
echo '＝＝＝入力処理開始＝＝＝'
start_time=`date +%s`

java -cp 'lib/*:target/*' \
org.springframework.batch.core.launch.support.CommandLineJobRunner \
META-INF/jobs/csvtodb/Info1Tasklet.xml \
Info1Tasklet \
inputFile=files/input/input-info1-data.csv

end_time=`date +%s`
time1=$((end_time - start_time))
echo '＝＝＝入力処理終了＝＝＝'
echo '処理結果:' $?

wait $!

#DB→CSVチャンク
echo '＝＝＝CSV出力処理開始＝＝＝'
start_time=`date +%s`

java -cp 'lib/*:target/*' \
org.springframework.batch.core.launch.support.CommandLineJobRunner \
META-INF/jobs/dbtocsv/Info1Chunk.xml \
Info1Chunk \
outputFile=files/output/output-info1-data.csv

end_time=`date +%s`
time2=$((end_time - start_time))
echo '＝＝＝CSV出力処理終了＝＝＝'
echo '処理結果:' $?

wait $!

echo '＝＝＝Info2＝＝＝'
#CSV→DBタスクレット
echo '＝＝＝入力処理開始＝＝＝'
start_time=`date +%s`

java -cp 'lib/*:target/*' \
org.springframework.batch.core.launch.support.CommandLineJobRunner \
META-INF/jobs/csvtodb/Info2Tasklet.xml \
Info2Tasklet \
inputFile=files/input/input-info2-data.csv

end_time=`date +%s`
time3=$((end_time - start_time))
echo '＝＝＝入力処理終了＝＝＝'
echo '処理結果:' $?

wait $!

#DB→CSVチャンク
echo '＝＝＝CSV出力処理開始＝＝＝'
start_time=`date +%s`

java -cp 'lib/*:target/*' \
org.springframework.batch.core.launch.support.CommandLineJobRunner \
META-INF/jobs/dbtocsv/Info2Chunk.xml \
Info2Chunk \
outputFile=files/output/output-info2-data.csv

end_time=`date +%s`
time4=$((end_time - start_time))
echo '＝＝＝CSV出力処理終了＝＝＝'
echo '処理結果:' $?

echo $time1
echo $time2
echo $time3
echo $time4