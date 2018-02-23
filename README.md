[![Build Status](https://travis-ci.org/SiwyDym/simple-search-engine.svg?branch=master)](https://travis-ci.org/SiwyDym/simple-search-engine)
# simple-search-engine

Simple search app wrote in Java. Engine is implemented as an inverted index. Divide Document on distinct terms with computed only naive(local) weight.

##Assumption
`The search engine should:`

1. be able to take in a list of documents
2. support searches for single terms in the document set
3. return a list of matching documents sorted by TF-IDF
