const path = require('path');
module.exports = {
    // JavaScript 执行入口文件
    entry: './main.js',
    output: {
        // 将所有依赖的模块合并输出到一个bundle.js文件中
        filename: 'bundle.js',
        // 将输出文件都放到dist目录下
        path: path.resolve(__dirname, './dist'),
    },
    module: {
        rules: [
            {
                // 用正则表达式去匹配要用该Loader转换的CSS文件
                test: /\.css$/,
                use: ['style-loader', 'css-loader'],
            }
        ]
    }
}