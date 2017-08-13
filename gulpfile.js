'use strict';

var gulp = require('gulp');
var gutil = require('gulp-util');
var gulpSequence = require('gulp-sequence');

var gulp = require('gulp');
var sass = require('gulp-sass');

gulp.task('sass', function () {
    return gulp.src('src/main/webapp/sass/*.scss')
        .pipe(sass().on('error', sass.logError))
        .pipe(gulp.dest('src/main/webapp/css'));
});

gulp.task('sass:watch', function () {
    gulp.watch('src/main/webapp/sass/*.scss', ['sass']);
});

