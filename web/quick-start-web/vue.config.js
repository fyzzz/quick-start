module.exports = {
    publicPath: '/',
    outputDir : 'dist',
    indexPath : 'index.html',
    devServer : {
        proxy: 'http://localhost:8090'
    }
};