package leetcode.codingchallenge2021.may

object FindDuplicateFileInSystem {
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val cache = mutableMapOf<String, MutableList<String>>()

        paths.forEach { path ->
            val (dir, fileList) = path.split(' ').let { Pair(it[0], it.drop(1)) }
            fileList.forEach { file ->
                val (x, y) = Pair(file.lastIndexOf('('), file.lastIndexOf(')'))
                val content = file.substring(x + 1, y)
                val fileName = file.substring(0, x)
                when (val acc = cache[content]) {
                    null -> cache += (content to mutableListOf("$dir/$fileName"))
                    else -> acc += "$dir/$fileName"
                }
            }
        }
        return cache.values.filter { it.size != 1 }.toList()
    }
}
