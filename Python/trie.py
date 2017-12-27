class TrieNode:
    def __init__(self, children=None, is_end=False):
        self.children = children or {}
        self.is_end = is_end

    def __len__(self):
        return len(self.children)


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        current = self.root
        for ch in word:
            temp = current.children.get(ch, None)
            if not temp:
                temp = TrieNode()
                current.children[ch] = temp
            current = temp
        current.is_end = True

    def search(self, word):
        node = self.search_node(word)
        return node and node.is_end

    def starts_with(self, prefix):
        return self.search_node(prefix) is not None

    def search_node(self, word):
        current = self.root
        for ch in word:
            temp = current.children.get(ch, None)
            if not temp:
                return None
            current = temp
        return current

    def delete(self, word):
        self.delete_helper(self.root, word, 0)

    def delete_helper(self, current, word, index):
        if index == len(word):
            if not current.is_end:
                return False
            current.is_end = False
            return len(current.children) == 0

        ch = word[index]
        node = current.children.get(ch, None)
        if not node:
            return False
        should_delete_current_node = self.delete_helper(node, word, index + 1)
        if should_delete_current_node:
            del current.children[ch]
            return len(current.children) == 0
        return False


'''
# code below can be used to test 'Trie'

if __name__ == '__main__':
    trie = Trie()
    trie.insert('Fun')
    trie.insert('Food')
    trie.insert('Fame')
    trie.insert('Fault')
    print('Trie is', '' if trie.starts_with('F') else 'not', 'having words starting with F')
    print('Trie is', '' if trie.starts_with('D') else 'not', 'having words starting with D')
    print('Fun is', '' if trie.search('Fun') else 'not', 'present in trie.')
    print('Food is', '' if trie.search('Food') else 'not', 'present in trie.')
    print('Fame is', '' if trie.search('Fame') else 'not', 'present in trie.')
    print('Fault is', '' if trie.search('Fault') else 'not', 'present in trie.')
    trie.delete('Fault')
    print('Now "Fault" was removed from trie!')
    print('Fun is', '' if trie.search('Fun') else 'not', 'present in trie.')
    print('Food is', '' if trie.search('Food') else 'not', 'present in trie.')
    print('Fame is', '' if trie.search('Fame') else 'not', 'present in trie.')
    print('Fault is', '' if trie.search('Fault') else 'not', 'present in trie.')
'''
