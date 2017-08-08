'use strict';

var gulp = require('gulp');
var gutil = require('gulp-util');
var gulpSequence = require('gulp-sequence');

var gulp = require('gulp');
var sass = require('gulp-sass');

gulp.task('sass', function () {
    return gulp.src('src/main/resources/templates/sass/*.scss')
        .pipe(sass().on('error', sass.logError))
        .pipe(gulp.dest('src/main/resources/templates/css'));
});

gulp.task('sass:watch', function () {
    gulp.watch('src/main/resources/templates/sass/*.scss', ['sass']);
});

