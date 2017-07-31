var gulp = require('gulp');
var gutil = require('gulp-util');
var gulpSequence = require('gulp-sequence');
var uglify = require('gulp-uglify'); //压缩文件


gulp.task('default', function () {
    gutil.log('this is default task');
    gutil.log(gutil.colors.red('this font is red'));
    gutil.log(gutil.colors.green('this font is') + "green")
});


gulp.task('one',function () {
    console.log('one');
});


gulp.task('two',function () {
    console.log('two');
});


gulp.task('three',['one','two'],function () {
    console.log('three');
});

gulp.task('sequence', gulpSequence(['three','two','one'],'one',['one','three']));

gulp.task('uglifyjs', function () {
    gulp.src('src/js/**/*.js')
        .pipe(uglify())
        .pipe(gulp.dest('dist/js'))
});

