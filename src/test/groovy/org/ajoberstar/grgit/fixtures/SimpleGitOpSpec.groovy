package org.ajoberstar.grgit.fixtures

import spock.lang.Specification

import org.ajoberstar.grgit.service.RepositoryService
import org.ajoberstar.grgit.Grgit

import org.eclipse.jgit.api.Git

import org.junit.Rule
import org.junit.rules.TemporaryFolder

class SimpleGitOpSpec extends Specification {
	@Rule TemporaryFolder tempDir = new TemporaryFolder()

	RepositoryService grgit

	def setup() {
		File repoDir = tempDir.newFolder('repo')
		Git git = Git.init().setDirectory(repoDir).call()
		grgit = Grgit.open(repoDir)
	}

	protected File repoFile(String path, boolean makeDirs = true) {
		return GitTestUtil.repoFile(grgit, path, makeDirs)
	}
}
